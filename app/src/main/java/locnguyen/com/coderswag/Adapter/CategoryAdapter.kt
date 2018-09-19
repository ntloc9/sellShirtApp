package locnguyen.com.coderswag.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import locnguyen.com.coderswag.Model.Category
import locnguyen.com.coderswag.R

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter(){

    val categories = categories
    val context = context

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View
        val holder: ViewHolder
        if (convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.categories_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoriesImage)
            holder.categoryName = categoryView.findViewById(R.id.categoriesName)
            categoryView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder{
        var categoryName: TextView? = null
        var categoryImage: ImageView? = null
    }
}