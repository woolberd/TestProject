package com.example.presentation.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeDetailFragment :
    BaseFragment<FragmentDetailBinding, HomeDetailViewModel>(R.layout.fragment_detail) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: HomeDetailViewModel by viewModels()
    private val args: HomeDetailFragmentArgs by navArgs()

    override fun setupSubscribes() = with(binding) {
        viewModel.fetchDetail(args.id).subscribes(
            onFailure = {},
            onSuccess = { data ->
                data.image.let {
                    Glide.with(img.context).load(it)
                        .into(img)
                }
                textDetail.text = data.title
                textDetail2.text = data.originalTitle
            }
        )
    }
}

