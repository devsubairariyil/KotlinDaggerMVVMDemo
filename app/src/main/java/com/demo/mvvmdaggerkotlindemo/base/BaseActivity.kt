package com.demo.mvvmdaggerkotlindemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.demo.mvvmdaggerkotlindemo.logger.AplLogger
import com.demo.mvvmdaggerkotlindemo.R
import com.demo.mvvmdaggerkotlindemo.utils.FragmentUtils
import dagger.android.AndroidInjection
import javax.inject.Inject


abstract class BaseActivity<D : ViewDataBinding> : AppCompatActivity() {


    lateinit var dataBinding: D

    @Inject
    lateinit var logger: AplLogger

    @get:LayoutRes
    protected abstract val layoutRes: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)

        setSupportActionBar(getToolbar())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, getRootFragment())
                .commitNow()
        }
    }


    fun replaceFragment(fragment: BaseFragment<*, *>) {
        FragmentUtils.replaceFragment(
            this, fragment, R.id.container, true,
            fragment.getFragmentTag(),
            FragmentUtils.TRANSITION_NONE
        )
    }

    abstract fun  getRootFragment(): BaseFragment<*, *>


    fun updateScreenTitle(title: String){
        getToolbar()?.title = title
    }

    fun getCurrentFragment(): BaseFragment<*, *>?{
        return supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment<*, *>

    }

    abstract fun getToolbar() : Toolbar?
}
