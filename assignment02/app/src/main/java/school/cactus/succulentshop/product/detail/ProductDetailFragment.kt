package school.cactus.succulentshop.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.FragmentProductDetailBinding
import school.cactus.succulentshop.product.BUNDLE_KEY_PRODUCT_ID
import school.cactus.succulentshop.product.list.ProductListFragmentDirections
import school.cactus.succulentshop.product.list.ProductStore

class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null

    private val binding get() = _binding!!
    private val adapter = ProductDetailAdapter()
    private val store = ProductStore()

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

        val productId = requireArguments().getInt(BUNDLE_KEY_PRODUCT_ID)
        val product = store.findProduct(productId)
        val relatedProducts=store.relatedProducts(productId)

        binding.apply {
            imageView.setImageResource(product.imageUrl)
            titleText.text = product.title
            priceText.text = product.price
            descriptionText.text = product.description
            recyclerViewHorizontal.layoutManager=LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
            recyclerViewHorizontal.adapter = adapter
            recyclerViewHorizontal.addItemDecoration(ProductDetailDecoration())
            adapter.submitList(relatedProducts)
        }
        adapter.itemClickListener = {
            val action = ProductDetailFragmentDirections.openProductDetailItem(it.id)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}