package tk.zedlabs.flobiz.network

import tk.zedlabs.flobiz.models.WeatherResponse

class WeatherRepository(val cityName: String) {

    var client = RetrofitService.createService2(JsonApiWeather::class.java)
    suspend fun getData() : WeatherResponse{
        return client.getData(cityName , "metric", "615f14c55db3b977157e1ea2887870d4")
    }

}