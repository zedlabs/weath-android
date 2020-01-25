package tk.zedlabs.flobiz.network

import retrofit2.http.GET
import tk.zedlabs.flobiz.models.CityList

interface JsonApi {

    @GET("/bins/lw9qf/")
    suspend fun getData() : CityList
}