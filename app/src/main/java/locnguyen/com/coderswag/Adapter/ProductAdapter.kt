package locnguyen.com.coderswag.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import locnguyen.com.coderswag.Model.Product
import locnguyen.com.coderswag.R
import java.util.zip.Inflater

class ProductAdapter(val context : Context, val products : List<Product>) : RecyclerView.Adapter<ProductAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_view, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindProduct(products[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context){
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)

            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
        }
    }

}