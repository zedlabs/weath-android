package tk.zedlabs.flobiz.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListData {
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("main")
    @Expose
    val main: Main? = null
    @SerializedName("rain")
    @Expose
    val rain: Any? = null
    @SerializedName("snow")
    @Expose
    val snow: Any? = null
    @SerializedName("weather")
    @Expose
    val weather: List<Weather>? = null
}