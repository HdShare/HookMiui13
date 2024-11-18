package me.hd.hookmiui13.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookmiui13.BuildConfig
import me.hd.hookmiui13.hook.hookers.adsolution.RemoveOpenAds
import me.hd.hookmiui13.hook.hookers.mms.RemoveMenuAndBtn
import me.hd.hookmiui13.hook.hookers.security.RemoveWait
import me.hd.hookmiui13.hook.hookers.updater.BlockUpdate

@InjectYukiHookWithXposed(entryClassName = "Entry")
object HookEntry : IYukiHookXposedInit {
    override fun onInit() = configs {
        debugLog {
            tag = BuildConfig.TAG
        }
        //isDebug = BuildConfig.DEBUG
        isDebug = false
    }

    override fun onHook() = encase {
        loadApp("com.android.updater") {
            loadHooker(BlockUpdate)
        }
        loadApp("com.miui.securitycenter") {
            loadHooker(RemoveWait)
        }
        loadApp("com.android.mms") {
            loadHooker(RemoveMenuAndBtn)
        }
        loadApp("com.miui.systemAdSolution") {
            loadHooker(RemoveOpenAds)
        }
    }
}