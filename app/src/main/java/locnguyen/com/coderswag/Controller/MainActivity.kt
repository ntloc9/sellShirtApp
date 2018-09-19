package locnguyen.com.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import locnguyen.com.coderswag.Adapter.CategoryAdapter
import locnguyen.com.coderswag.Model.Category
import locnguyen.com.coderswag.R
import locnguyen.com.coderswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        categoriesListview.adapter = adapter
    }
}

