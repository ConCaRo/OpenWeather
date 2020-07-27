package trong.ccr.weather.features.search

import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import trong.ccr.weather.data.source.AppRepository
import trong.ccr.weather.data.source.entity.Weather
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    companion object {
        const val DEFAULT_PLACE = "saigon"
    }

    private val query: MutableLiveData<String> =
        MutableLiveData<String>().apply { value = DEFAULT_PLACE }

    private var _weathers: LiveData<List<Weather>> = query.asFlow()
        .debounce(300)
        .filter {
            it.length >= 3
        }.flatMapLatest {
            appRepository.searchWeathers(it)
        }
        .onCompletion {}
        .catch { throwable -> print(throwable.message) }
        .asLiveData()
    val weather: LiveData<List<Weather>> = _weathers

    fun search(text: String) {
        query.value = text
    }
}
