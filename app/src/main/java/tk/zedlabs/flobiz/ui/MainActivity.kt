package tk.zedlabs.flobiz.ui

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tk.zedlabs.flobiz.R
import tk.zedlabs.flobiz.models.City
import tk.zedlabs.flobiz.viewmodels.MainViewModel


class MainActivity : AppCompatActivity(),
    CityListAdapter.OnImageListener {

    private lateinit var viewModel: MainViewModel

    override fun onImageClick(position: Int) {
        val i = Intent(this, WeatherDetailsActivity::class.java)
        val cityName = viewModel.data.value?.cities?.get(position)?.name
        i.putExtra("city-name", cityName)
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        val tv = TextView(applicationContext)
        val typeface = ResourcesCompat.getFont(this, R.font.roboto_slab_light)
        val lp = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,  RelativeLayout.LayoutParams.WRAP_CONTENT)

        tv.layoutParams = lp
        tv.text = "Weather App"

        tv.textSize = 25f
        tv.setTextColor(Color.WHITE)
        tv.typeface = typeface
        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.customView = tv
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        showData()
    }

    private fun showData() {
        var cityList : List<City>
        val viewManager = LinearLayoutManager(this)
        viewModel.data.observe(this, Observer {
            cityList = it.cities!!
            val viewAdapter =
                CityListAdapter(cityList, this)
            recycler_view_city.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })
    }


}
