package tk.zedlabs.flobiz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import tk.zedlabs.flobiz.models.WeatherResponse
import tk.zedlabs.flobiz.network.WeatherRepository

class WeatherDetailsViewModel(cityName : String) : ViewModel(){
    private val repository: WeatherRepository = WeatherRepository(cityName)

    val data : LiveData<WeatherResponse> = liveData(Dispatchers.IO) {
        val retrievedData: WeatherResponse = repository.getData()
        emit(retrievedData)
    }
}