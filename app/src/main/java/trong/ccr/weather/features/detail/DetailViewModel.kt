package trong.ccr.weather.features.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.entity.Weather

class DetailViewModel @ViewModelInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    appRepository: AppRepository
) : ViewModel() {

    private val _weather: LiveData<Weather> =
        appRepository.getWeather(savedStateHandle["id"] ?: 0).asLiveData()
    val weather = _weather
}