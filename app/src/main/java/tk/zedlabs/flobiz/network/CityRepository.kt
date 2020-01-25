package tk.zedlabs.flobiz.network

class CityRepository {

    var client = RetrofitService.createService(JsonApi::class.java)
        suspend fun getData() = client.getData()
}