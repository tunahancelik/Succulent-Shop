package school.cactus.succulentshop.product.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import school.cactus.succulentshop.databinding.DetailItemReleatedproductBinding
import school.cactus.succulentshop.product.ProductItem


class ProductDetailAdapter :
    ListAdapter<ProductItem, ProductDetailAdapter.ProductDetailHolder>(DIFF_CALLBACK) {
    var itemClickListener: (ProductItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailHolder {
        val binding = DetailItemReleatedproductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductDetailHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: ProductDetailHolder, position: Int) =
        holder.bind(getItem(position))

    class ProductDetailHolder(
        private val binding: DetailItemReleatedproductBinding,
        private val itemClickListener: (ProductItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductItem) {
            binding.detailTitleText.text = product.title
            binding.detailPriceText.text = product.price

            Glide.with(binding.root.context)
                .load(product.imageUrl)
                .centerInside()
                .into(binding.detaiImageView)

            binding.root.setOnClickListener {
                itemClickListener(product)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductItem>() {
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem) =
                oldItem == newItem
        }
    }


}

