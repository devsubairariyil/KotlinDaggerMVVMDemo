package com.demo.mvvmdaggerkotlindemo

import androidx.appcompat.widget.Toolbar
import com.demo.mvvmdaggerkotlindemo.base.BaseActivity
import com.demo.mvvmdaggerkotlindemo.base.BaseFragment
import com.demo.mvvmdaggerkotlindemo.databinding.MainActivityBinding
import com.demo.mvvmdaggerkotlindemo.ui.main.MainFragment

class MainActivity : BaseActivity<MainActivityBinding>() {

    override val layoutRes: Int
        get() = R.layout.main_activity

    override fun getRootFragment(): BaseFragment<*, *> {
        return MainFragment.newInstance()
    }

    override fun getToolbar(): Toolbar? {
        return dataBinding.toolbar
    }

}
