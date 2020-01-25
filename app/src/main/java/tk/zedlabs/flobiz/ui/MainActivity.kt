package tk.zedlabs.flobiz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tk.zedlabs.flobiz.CityListAdapter
import tk.zedlabs.flobiz.viewmodels.MainViewModel
import tk.zedlabs.flobiz.R
import tk.zedlabs.flobiz.models.City

class MainActivity : AppCompatActivity(),
    CityListAdapter.OnImageListener {

    private lateinit var viewModel: MainViewModel

    override fun onImageClick(position: Int) {
        val i = Intent(this, WeatherDetailsActivity::class.java)
        val cityName = viewModel.data.value?.cities?.get(position)?.name
        i.putExtra("city-name", cityName)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        showData()
    }

    private fun showData() {
        var cityList : List<City>
        val viewManager = LinearLayoutManager(this)
        viewModel.data.observe(this, Observer {
            cityList = it.cities!!
            val viewAdapter = CityListAdapter(cityList, this)
            recycler_view_city.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })
    }


}
