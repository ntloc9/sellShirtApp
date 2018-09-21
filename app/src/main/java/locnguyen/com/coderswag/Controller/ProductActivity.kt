package locnguyen.com.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_product.*
import locnguyen.com.coderswag.Adapter.ProductAdapter
import locnguyen.com.coderswag.R
import locnguyen.com.coderswag.Services.DataService
import locnguyen.com.coderswag.Ultilities.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductAdapter(this, DataService.getCatgory(categoryType))

        productListView.adapter = adapter

        val layoutManager = GridLayoutManager(this, 2)
        productListView.layoutManager = layoutManager
    }
}
