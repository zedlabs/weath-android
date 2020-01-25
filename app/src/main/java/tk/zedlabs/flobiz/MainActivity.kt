package tk.zedlabs.flobiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.wait
import tk.zedlabs.flobiz.models.City
import tk.zedlabs.flobiz.models.CityList

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        showData()
    }

    private fun showData() {
        var cityList : List<City>
        viewModel.data.observe(this, Observer {
            cityList = it.cities!!
            recycler_view_city.adapter = CityListAdapter(cityList)
            val viewManager = LinearLayoutManager(this)
            val viewAdapter = CityListAdapter(cityList)
            recycler_view_city.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })

    }

}
