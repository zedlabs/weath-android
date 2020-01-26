package tk.zedlabs.flobiz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_weather_details.*
import tk.zedlabs.flobiz.R
import tk.zedlabs.flobiz.viewmodels.WeatherDetailsViewModel

class WeatherDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel : WeatherDetailsViewModel
    private lateinit var cityName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
        supportActionBar?.hide()

        val intent = intent
        cityName = intent.getStringExtra("city-name")!!
        viewModel = WeatherDetailsViewModel(cityName)
        back_image.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }
        showData()
    }
    private fun showData() {
        viewModel.data.observe(this, Observer {
            locationTv.text = cityName.toUpperCase()
            val main1 = it.main
            tempratureCurrent.text = main1?.temp.toString() + "°"
            description.text = it.weather?.get(0)?.description
            minVal.text = main1?.tempMin.toString() + "°"
            maxVal.text = main1?.tempMax.toString() + "°"
            pressureVal.text = main1?.pressure.toString()
            humidityVal.text = main1?.humidity.toString()
            windVal.text = main1?.humidity.toString()

        })
    }
}
