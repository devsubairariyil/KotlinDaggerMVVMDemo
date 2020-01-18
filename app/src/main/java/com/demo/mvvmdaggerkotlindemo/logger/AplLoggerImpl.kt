package com.demo.mvvmdaggerkotlindemo.logger

import timber.log.Timber
import javax.inject.Singleton

@Singleton
public class AplLoggerImpl : AplLogger {

    override fun logDebugMessage(msg: String) {
        Timber.v(msg)
    }

    override fun logVerbose(mesg: String) {
        Timber.v(mesg)
    }

    override fun logInfo(mesg: String) {
        Timber.i(mesg)
    }

    override fun logError(mesg: String) {
        Timber.e(mesg)
    }

    override fun logWanring(mesg: String) {
        Timber.w(mesg)
    }

    override fun logThrowable(msg: String, e: Throwable) {
        Timber.e(e, msg)
    }


}
