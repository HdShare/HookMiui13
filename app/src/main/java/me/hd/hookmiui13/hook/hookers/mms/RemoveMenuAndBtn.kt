package me.hd.hookmiui13.hook.hookers.mms

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookmiui13.data.PrefsData
import org.json.JSONObject

object RemoveMenuAndBtn : YukiBaseHooker() {
    override fun onHook() {
        if (!prefs.get(PrefsData.REMOVE_MENU_AND_BTN)) return
        "com.miui.smsextra.http.RequestResult".toClass().method {
            name = "data"
            emptyParam()
        }.hook {
            after {
                result?.let {
                    val jsonObj = JSONObject(it.toString())
                    val isModule = jsonObj.has("modules")
                    val isAdInfo = jsonObj.has("adInfos")
                    if (isModule || isAdInfo) {
                        result = JSONObject().toString()
                    }
                }
            }
        }
    }
}