package me.hd.hookmiui13.hook.hookers.updater

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import me.hd.hookmiui13.data.PrefsData
import me.hd.hookmiui13.hook.utils.DexKitUtil

object BlockUpdate : YukiBaseHooker() {
    override fun onHook() {
        if (!prefs.get(PrefsData.BLOCK_UPDATE)) return
        DexKitUtil.create(this) {
            findMethod {
                findFirst = true
                searchPackages("com.android.updater")
                matcher {
                    usingEqStrings("update_params", "token", "security")
                }
            }.single().getMethodInstance(appClassLoader!!).hook {
                before {
                    result = null
                }
            }
        }
    }
}