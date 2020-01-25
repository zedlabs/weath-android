package tk.zedlabs.flobiz.network

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query
import tk.zedlabs.flobiz.models.WeatherResponse

interface JsonApiWeather {

    @GET("/data/2.5/weather/")
    suspend fun getData(@Query("q") location : String,
                        @Query("units") units : String,
                        @Query("appid") id : String) : WeatherResponse

}