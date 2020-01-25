package tk.zedlabs.flobiz.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Main {
    @SerializedName("temp")
    @Expose
    val temp: Any? = null
    @SerializedName("pressure")
    @Expose
    val pressure: Any? = null
    @SerializedName("humidity")
    @Expose
    val humidity: Any? = null
    @SerializedName("temp_min")
    @Expose
    val tempMin: Any? = null
    @SerializedName("temp_max")
    @Expose
    val tempMax: Any? = null

}