package me.hd.hookmiui13.hook.hookers.adsolution

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookmiui13.data.PrefsData

object RemoveOpenAds : YukiBaseHooker() {
    override fun onHook() {
        if (!prefs.get(PrefsData.REMOVE_OPEN_ADS)) return
        "com.xiaomi.ad.entity.contract.AdResponseEntityBase".toClass().method {
            name = "getAdInfos"
            emptyParam()
        }.hook {
            after {
                result = emptyList<Any>()
            }
        }
    }
}