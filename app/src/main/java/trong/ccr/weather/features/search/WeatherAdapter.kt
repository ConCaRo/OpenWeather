package trong.ccr.weather.features.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import trong.ccr.weather.data.source.entity.Weather
import trong.ccr.weather.databinding.ItemWeatherBinding

class WeatherAdapter(val click: (Weather) -> Unit) : ListAdapter<Weather, RecyclerView.ViewHolder>(WeatherDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val weather = getItem(position)
        (holder as WeatherViewHolder).bind(weather)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeatherViewHolder(
            ItemWeatherBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class WeatherViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(_item: Weather) {
            binding.apply {
                item = _item
                executePendingBindings()
            }
            itemView.setOnClickListener {
                click(_item)
            }
        }
    }
}

private class WeatherDiffCallback : DiffUtil.ItemCallback<Weather>() {

    override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem == newItem
    }
}