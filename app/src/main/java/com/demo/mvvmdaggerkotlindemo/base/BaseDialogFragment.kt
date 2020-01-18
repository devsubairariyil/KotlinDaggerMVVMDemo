package com.demo.mvvmdaggerkotlindemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.demo.mvvmdaggerkotlindemo.logger.AplLogger
import dagger.android.support.AndroidSupportInjection
import java.util.*
import javax.inject.Inject

abstract class BaseDialogFragment<V : BaseViewModel, D : ViewDataBinding> : DialogFragment() {


    @Inject
    lateinit var logger: AplLogger
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: V

    protected lateinit var dataBinding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeBaseLiveData()
        dataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (Objects.requireNonNull(activity) as BaseActivity<*>)
            .updateScreenTitle(getScreenTitle())


    }



    abstract fun getScreenTitle() : String

    private fun observeBaseLiveData(){
        observeLiveData()
    }
    open fun observeLiveData(){

    }
}