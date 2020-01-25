package tk.zedlabs.flobiz.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City {
    @SerializedName("name")
    @Expose
    var name: String? = null

}