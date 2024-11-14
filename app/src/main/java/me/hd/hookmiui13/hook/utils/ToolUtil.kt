package me.hd.hookmiui13.hook.utils

import com.highcapable.yukihookapi.hook.log.YLog

object ToolUtil {
    fun printStackTrace() {
        val stackTrace = Throwable().stackTrace
        val stackTraceStr = stackTrace.joinToString("\n") { element ->
            "at ${element.className}.${element.methodName}(${element.fileName}:${element.lineNumber})"
        }
        YLog.error("StackTrace\n$stackTraceStr")
    }
}