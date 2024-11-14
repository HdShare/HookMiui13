package me.hd.hookmiui13.ui

import android.content.Context
import android.os.Bundle
import com.highcapable.yukihookapi.hook.xposed.prefs.ui.ModulePreferenceFragment
import me.hd.hookmiui13.R

class PrefsFragment : ModulePreferenceFragment() {

    //==============================================================================================
    // YukiHookAPI 1.2.1 存在的 Issue(#86), 已在 Pr(#87) 中修复, 但暂未发版, 先通过以下方式暂时解决
    private val prefsName get() = "${activity?.packageName}_preferences"
    private val currentActivity get() = requireActivity()
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        currentActivity.getSharedPreferences(prefsName, Context.MODE_WORLD_READABLE)
        super.onCreatePreferences(savedInstanceState, rootKey)
    }
    //==============================================================================================

    override fun onCreatePreferencesInModuleApp(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.prefs)
    }
}