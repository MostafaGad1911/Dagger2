package mostafa.projects.dagger2.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.apiTask.AppsSquare.Model.Product
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import mostafa.projects.dagger2.R

class ProductsAdapter(private var products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {


    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImg: ImageView? = itemView.findViewById(R.id.productImg)
        var productTitleTxt: TextView? = itemView.findViewById(R.id.productTitleTxt)
        var productPriceTxt:TextView = itemView.findViewById(R.id.productPriceTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.products_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
        Glide.with(holder.itemView.context).load(product.image).fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.productImg!!)
        holder.productTitleTxt?.text = product.name
        holder.productPriceTxt.text =
            HtmlCompat.fromHtml(
                "${product.price} ${holder.itemView.context.getCurrency()}",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )


    }

    override fun getItemCount(): Int {
        return products.size
    }

    private fun Context.getCurrency(): String {
        return "<b><font color='red'>${getString(R.string.curr)}</font></b>"
    }
}