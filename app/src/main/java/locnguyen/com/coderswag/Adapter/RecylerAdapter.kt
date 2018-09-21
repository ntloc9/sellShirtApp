package locnguyen.com.coderswag.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import locnguyen.com.coderswag.Model.Category
import locnguyen.com.coderswag.R

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemCLick : (Category) -> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.categories_list_item, parent, false)
        return Holder(view, itemCLick)
    }

    inner class Holder(itemView: View?, val itemCLick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image,
                    "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
            itemView.setOnClickListener { itemCLick(category) }
        }
    }
}