package com.demo.mvvmdaggerkotlindemo.ui.main

import com.demo.mvvmdaggerkotlindemo.base.BaseFragment
import com.demo.mvvmdaggerkotlindemo.R
import com.demo.mvvmdaggerkotlindemo.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainViewModel, MainFragmentBinding>() {
    override fun getScreenTitle(): String {
        return "Under Construction"
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override val layoutRes: Int
        get() = R.layout.main_fragment

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

}
