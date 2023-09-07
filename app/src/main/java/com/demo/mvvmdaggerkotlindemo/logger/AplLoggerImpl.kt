package com.demo.mvvmdaggerkotlindemo.logger

import timber.log.Timber
import java.io.File
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



    public void deleteOldLogFiles(String logFolderPath) {
        File logFolder = new File(logFolderPath);
        long thirtyDaysInMillis = 30L * 24 * 60 * 60 * 1000; // 30 days in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        File[] logFiles = logFolder.listFiles();
        if (logFiles != null) {
            for (File file : logFiles) {
                if (file.isFile() && currentTimeMillis - file.lastModified() > thirtyDaysInMillis) {
                    if (file.delete()) {
                        System.out.println("Deleted old log file: " + file.getName());
                    } else {
                        System.err.println("Failed to delete log file: " + file.getName());
                    }
                }
            }
        }
    }

}
