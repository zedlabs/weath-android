package tk.zedlabs.flobiz

import retrofit2.http.GET
import tk.zedlabs.flobiz.models.CityList

interface JsonApi {

    @GET("/bins/lw9qf/")
    suspend fun getData() : CityList
}