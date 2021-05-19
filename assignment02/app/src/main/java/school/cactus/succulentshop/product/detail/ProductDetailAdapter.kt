package school.cactus.succulentshop.product.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import school.cactus.succulentshop.databinding.ItemDetailProductBinding
import school.cactus.succulentshop.product.list.Product
import school.cactus.succulentshop.product.detail.ProductDetailAdapter.ProductDetailHolder

class ProductDetailAdapter : ListAdapter<Product, ProductDetailHolder>(DIFF_CALLBACK) {

    var itemClickListener: (Product) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailHolder {
        val bindings = ItemDetailProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductDetailHolder(bindings, itemClickListener)
    }

    override fun onBindViewHolder(holder: ProductDetailHolder, position: Int) =
        holder.bind(getItem(position))

    class ProductDetailHolder(
        private val binding: ItemDetailProductBinding,
        private val itemClickListener: (Product) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.titleText.text = product.title
            binding.priceText.text = product.price
            binding.imageView.setImageResource(product.imageUrl)

            Glide.with(binding.root.context)
                .load(product.imageUrl)
                .override(512)
                .into(binding.imageView)

            binding.root.setOnClickListener {
                itemClickListener(product)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        }
    }


}