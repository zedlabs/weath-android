package tk.zedlabs.flobiz.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class WeatherResponse {


    @SerializedName("weather")
    @Expose
    val weather: List<Weather>? = null
    @SerializedName("base")
    @Expose
    val base: String? = null
    @SerializedName("main")
    @Expose
    val main: Main? = null
    @SerializedName("dt")
    @Expose
    val dt: Any? = null
    @SerializedName("timezone")
    @Expose
    val timezone: Any? = null
    @SerializedName("id")
    @Expose
    val id: Any? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("cod")
    @Expose
    val cod: Any? = null
}