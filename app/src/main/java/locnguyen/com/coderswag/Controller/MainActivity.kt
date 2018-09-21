package locnguyen.com.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import locnguyen.com.coderswag.Adapter.CategoryAdapter
import locnguyen.com.coderswag.Adapter.CategoryRecycleAdapter
import locnguyen.com.coderswag.Model.Category
import locnguyen.com.coderswag.R
import locnguyen.com.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*
import locnguyen.com.coderswag.Ultilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

    }
}

