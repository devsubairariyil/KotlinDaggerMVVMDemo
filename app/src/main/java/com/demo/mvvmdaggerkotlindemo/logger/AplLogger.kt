package com.demo.mvvmdaggerkotlindemo.logger

public interface AplLogger{
    fun logDebugMessage(msg: String)

    fun logVerbose(mesg: String)

    fun logInfo(mesg: String)

    fun logError(mesg: String)

    fun logWanring(mesg: String)

    fun logThrowable(msg: String, e: Throwable)
}