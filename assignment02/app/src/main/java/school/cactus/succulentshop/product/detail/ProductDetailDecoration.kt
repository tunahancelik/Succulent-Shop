package school.cactus.succulentshop.product.detail

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import school.cactus.succulentshop.R


class ProductDetailDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val spacingLeft = view.context.resources.getDimensionPixelSize(R.dimen.item_detail_product_spacingLeft)
        val spacingTop = view.context.resources.getDimensionPixelSize(R.dimen.item_detail_product_spacingTop)
        outRect.left=spacingLeft
        outRect.top=spacingTop
    }
}