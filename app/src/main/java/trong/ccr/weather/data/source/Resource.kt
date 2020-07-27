package trong.ccr.weather.data.source


/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class Resource<out T>(val status: Status, val data: T?, val message: String?, val error: Throwable? = null) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Throwable, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, error.message, error)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    override fun toString(): String {
        return when (this.status) {
            Status.SUCCESS -> "Success[data=$data]"
            Status.ERROR -> "Error[exception=$error]"
            else -> "Loading[data=$data]"
        }
    }
}
