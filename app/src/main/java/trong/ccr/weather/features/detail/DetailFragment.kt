package trong.ccr.weather.features.detail

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import trong.ccr.weather.R
import trong.ccr.weather.databinding.FragmentDetailBinding
import trong.ccr.weather.features.BaseFragment

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>(R.layout.fragment_detail) {

    private val vm: DetailViewModel by viewModels()

    override  fun initViewModel()  {
        viewModel = vm
        binding.vm = viewModel
        binding?.lifecycleOwner = viewLifecycleOwner
        observeChanges()
    }

    private fun observeChanges() {
    }

    override fun setViews() {
    }
}