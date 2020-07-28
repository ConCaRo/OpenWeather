package trong.ccr.weather.features.search

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import trong.ccr.weather.R
import trong.ccr.weather.data.source.Status
import trong.ccr.weather.databinding.FragmentSearchBinding
import trong.ccr.weather.features.BaseFragment
import trong.ccr.weather.features.ViewModelFactory
import trong.ccr.weather.features.autoCleared
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<SearchViewModel, FragmentSearchBinding>(R.layout.fragment_search) {

    @Inject
    lateinit var factory: ViewModelFactory<SearchViewModel>

    private var adapter by autoCleared<WeatherAdapter>()

    override fun initViewModel() {
        viewModel = ViewModelProvider(this, factory).get(SearchViewModel::class.java)
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.vm = viewModel
        observeChanges()
    }

    private fun observeChanges() {
        viewModel.weather.observe(viewLifecycleOwner, Observer {
            if(it.status == Status.ERROR) {
                adapter?.submitList(null)
            } else if(it.status == Status.LOADING || it.data != null) {
                adapter?.submitList(it.data)
            }
        })
    }

    override fun setViews() {
        adapter = WeatherAdapter {
            findNavController().navigate(
                R.id.action_SearchFragment_to_DetailFragment,
                bundleOf("id" to it.id)
            )
        }
        binding?.recyclerview?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = this@SearchFragment.adapter
            setHasFixedSize(true)
        }

    }
}