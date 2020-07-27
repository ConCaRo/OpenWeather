package trong.ccr.weather.features.detail

import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import trong.ccr.weather.R
import trong.ccr.weather.databinding.FragmentDetailBinding
import trong.ccr.weather.features.BaseFragment
import trong.ccr.weather.features.ViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>(R.layout.fragment_detail) {

    @Inject
    lateinit var factory: ViewModelFactory<DetailViewModel>

    override  fun initViewModel()  {
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        binding.vm = viewModel
        binding?.lifecycleOwner = viewLifecycleOwner
        observeChanges()
    }

    private fun observeChanges() {
    }

    override fun setViews() {
    }
}