package school.cactus.succulentshop.product.detail

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import school.cactus.succulentshop.R

class ProductDetailDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val spacing = view.context.resources.getDimensionPixelSize(R.dimen.item_product_spacing)
        val position = parent.getChildAdapterPosition(view)

        if (position >= 1) {
            outRect.left = spacing * 2
        }
        outRect.bottom = spacing * 2

    }

}
