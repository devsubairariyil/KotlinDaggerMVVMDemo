package com.demo.mvvmdaggerkotlindemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.demo.mvvmdaggerkotlindemo.logger.AplLogger
import dagger.android.support.AndroidSupportInjection
import java.util.*
import javax.inject.Inject

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
abstract class BaseFragment<V : BaseViewModel, D : ViewDataBinding> : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var logger: AplLogger


    protected lateinit var viewModel: V

    protected lateinit var dataBinding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(hasToolbarMenu())
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

        (activity as? BaseActivity<*>)
            ?.updateScreenTitle(getScreenTitle())
    }

    protected fun changeFragment(fragment: BaseFragment<*, *>) {
        (Objects.requireNonNull(activity) as BaseActivity<*>).replaceFragment(fragment)
    }

    abstract fun getScreenTitle() : String

    fun showDialogFragment(dialogFragment: BaseDialogFragment<*, *>){
        val ft = fragmentManager!!.beginTransaction()
        val prev = fragmentManager!!.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)

        dialogFragment.show(ft, "dialog")
    }

    open fun hasToolbarMenu(): Boolean = false

    override fun onResume() {
        super.onResume()
        logger.logDebugMessage("On Resume")
    }

    override fun onStart() {
        super.onStart()
        logger.logDebugMessage("On Start")
    }

    fun getFragmentTag(): String{
        return this.javaClass.canonicalName
    }

    fun getAttachedViewModel(): BaseViewModel?{
        return viewModel
    }

    private fun observeBaseLiveData(){
        observeLiveData()
    }
    open fun observeLiveData(){

    }

    fun popCurrentFragment(){
        activity?.supportFragmentManager?.popBackStackImmediate()
    }

    fun showToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}