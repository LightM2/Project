package com.example.project

import com.example.project.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {
  override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

  override fun getLayoutId(): Int = R.layout.main_fragment

  companion object {
    fun newInstance() = MainFragment()
  }

  fun newInstance(): MainFragment {
    val fragment = MainFragment()
    return fragment
  }

  //private lateinit var viewModel: MainViewModel

}
