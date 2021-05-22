package school.cactus.succulentshop.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import school.cactus.succulentshop.R
import school.cactus.succulentshop.api.api
import school.cactus.succulentshop.api.product.Product
import school.cactus.succulentshop.databinding.FragmentProductDetailBinding
import school.cactus.succulentshop.product.toProductItem
import school.cactus.succulentshop.product.toProductItemList


class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null

    private val binding get() = _binding!!

    private val adapter = ProductDetailAdapter()

    private val args: ProductDetailFragmentArgs by navArgs()

    private var progressDetail = false
    private var progressRecyclerDetail = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().title = getString(R.string.app_name)

        binding.recyclerDetail.adapter = adapter
        binding.recyclerDetail.layoutManager =
            LinearLayoutManager(requireContext(), HORIZONTAL, false)
        binding.recyclerDetail.addItemDecoration(ProductDetailDecoration())

        adapter.itemClickListener = {
            val action = ProductDetailFragmentDirections.actionProductDetailFragmentSelf(it.id)
            findNavController().navigate(action)
        }

        fetchProduct()
        fetchRelatedProduct()
    }

    private fun fetchRelatedProduct() {
        api.relatedProducts(args.productId).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                when (response.code()) {
                    200 -> onRelatedSuccess(response.body()!!)
                    401 -> onTokenExpired()
                    else -> onUnexpectedError()
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Snackbar.make(
                    binding.root, R.string.check_your_connection,
                    Snackbar.LENGTH_LONG
                ).show()

            }
        })
    }

    private fun onRelatedSuccess(body: Product) {
        if (body.products.isEmpty()) {
            binding.releatedPoductsText.visibility = View.GONE
            progressRecyclerDetail = true
        } else {
            adapter.submitList(body.products.toProductItemList())
            progressRecyclerDetail = true
        }
        checkProgress(progressDetail, progressRecyclerDetail)
    }

    private fun fetchProduct() {
        api.getProductById(args.productId).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                when (response.code()) {
                    200 -> onSuccess(response.body()!!)
                    401 -> onTokenExpired()
                    else -> onUnexpectedError()
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Snackbar.make(
                    binding.root, R.string.check_your_connection,
                    Snackbar.LENGTH_INDEFINITE
                ).setAction(R.string.retry) {
                    fetchProduct()
                }.show()
            }
        })
    }

    private fun onSuccess(product: Product) {
        val productItem = product.toProductItem()
        progressDetail = true
        binding.apply {
            titleText.text = productItem.title
            priceText.text = productItem.price
            descriptionText.text = productItem.description

            Glide.with(binding.root)
                .load(productItem.highResImageUrl)
                .into(imageView)
        }
        checkProgress(progressDetail, progressRecyclerDetail)
    }

    private fun onTokenExpired() {
        Snackbar.make(
            binding.root, R.string.your_session_is_expired,
            Snackbar.LENGTH_SHORT
        ).show()
        findNavController().navigate(R.id.action_productListFragment_to_loginFragment)
    }

    private fun checkProgress(progressDetail: Boolean, progressRecycler: Boolean) {
        if (progressDetail && progressRecycler) {
            binding.detailProgressBar.visibility = View.GONE
        }
    }


    private fun onUnexpectedError() {
        Snackbar.make(
            binding.root, R.string.unexpected_error,
            BaseTransientBottomBar.LENGTH_LONG
        ).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

