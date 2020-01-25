package tk.zedlabs.flobiz

class CityRepository {

    var client = RetrofitService.createService(JsonApi::class.java)
        suspend fun getData() = client.getData()
}