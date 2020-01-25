package tk.zedlabs.flobiz.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CityList {
    @SerializedName("cities")
    @Expose
    var cities : List<City> ?= null
}