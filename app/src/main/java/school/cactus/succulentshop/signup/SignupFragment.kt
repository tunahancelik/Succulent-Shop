package school.cactus.succulentshop.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import school.cactus.succulentshop.R
import school.cactus.succulentshop.api.GenericErrorResponse
import school.cactus.succulentshop.api.api
import school.cactus.succulentshop.api.signup.SignupRequest
import school.cactus.succulentshop.api.signup.SignupResponse
import school.cactus.succulentshop.auth.JwtStore
import school.cactus.succulentshop.databinding.FragmentSignupBinding
import school.cactus.succulentshop.validation.IdentifierValidator
import school.cactus.succulentshop.validation.PasswordValidator
import school.cactus.succulentshop.validation.UsernameValidator


class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    private val identifierValidator = IdentifierValidator()
    private val usernameValidator = UsernameValidator()
    private val passwordnameValidator = PasswordValidator()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.sign_up)
        binding.apply {
            signupButton.setOnClickListener {
                if (outlinedTextFieldSignUpemail.signupValidate() and outlinedTextFieldSignUpusername.signupValidate() and outlinedTextFieldSignuppassword.signupValidate())
                    sendSignupRequest(
                        edttextSignUpEmail.text.toString(),
                        edttextSignupPassword.text.toString(),
                        edttextSignUpusername.text.toString()
                    )
            }

            alreadyHaveAccountButton.setOnClickListener {
                findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
            }
        }
    }

    private fun sendSignupRequest(email: String, password: String, username: String) {
        val requestSignup = SignupRequest(email, password, username)

        api.register(requestSignup).enqueue(object : Callback<SignupResponse> {
            override fun onResponse(
                call: Call<SignupResponse>,
                response: Response<SignupResponse>
            ) {
                when (response.code()) {
                    200 -> onSucces(response.body()!!)
                    in 400..499 -> onRequestFail(response.errorBody()!!)
                    else -> unexpectedError()
                }
            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                Snackbar.make(binding.root, R.string.check_your_connection, Snackbar.LENGTH_SHORT)
                    .show()
            }

        }

        )
    }

    private fun unexpectedError() {
        Snackbar.make(binding.root, R.string.unexpected_error, Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun onRequestFail(errorBody: ResponseBody) {
        if (errorBody == null) return unexpectedError()

        try {
            val message = errorBody.errorMessage()
            Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
                .show()
        } catch (e: JsonSyntaxException) {
            unexpectedError()
        }
    }

    private fun onSucces(body: SignupResponse) {
        JwtStore(requireContext()).saveJwt(body.jwt)
        findNavController().navigate(R.id.action_signupFragment_to_productListFragment)
    }

    private fun ResponseBody.errorMessage(): String {
        val errorBody = string()
        val gson: Gson = GsonBuilder().create()
        val errorMessage = gson.fromJson(errorBody, GenericErrorResponse::class.java)

        return errorMessage.message[0].messages[0].message
    }


    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.outlinedTextFieldSignUpemail -> identifierValidator
        binding.outlinedTextFieldSignUpusername -> usernameValidator
        binding.outlinedTextFieldSignuppassword -> passwordnameValidator
        else -> null
    }//

    private fun TextInputLayout.signupValidate(): Boolean {

        val errorMessage = validator()!!.signupValidate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
        return error == null
    }
}