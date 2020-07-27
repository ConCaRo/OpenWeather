package trong.ccr.weather.features.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import trong.ccr.weather.data.source.entity.Weather
import javax.inject.Inject

class DetailViewModel @Inject constructor() : ViewModel() {

    private val _weather = MutableLiveData<Weather>()
    val weather = _weather
}