package tk.zedlabs.flobiz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData
import tk.zedlabs.flobiz.network.CityRepository
import tk.zedlabs.flobiz.models.CityList


class MainViewModel : ViewModel() {
    private val repository: CityRepository = CityRepository()

    val data : LiveData<CityList> = liveData(Dispatchers.IO) {
        val retrievedData: CityList  = repository.getData()
        emit(retrievedData)
    }

}