package school.cactus.succulentshop.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.LoginActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignupBinding
import school.cactus.succulentshop.helpers.EmailValidator
import school.cactus.succulentshop.helpers.PasswordValidator
import school.cactus.succulentshop.helpers.UserNameValidator

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private val emailValidator = EmailValidator()
    private val userNameValidator = UserNameValidator()
    private val passwordValidator = PasswordValidator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            signUpButton.setOnClickListener {
                emailInputLayout.validate()
                usernameInputLayout.validate()
                passwordInputLayout.validate()
            }
            logInButton.setOnClickListener { navigateLoginPage() }
        }
    }

    fun navigateLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.emailInputLayout -> emailValidator
        binding.passwordInputLayout -> passwordValidator
        binding.usernameInputLayout -> userNameValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}