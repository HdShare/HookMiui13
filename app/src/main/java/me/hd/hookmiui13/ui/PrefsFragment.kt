package me.hd.hookmiui13.ui

import android.os.Bundle
import com.highcapable.yukihookapi.hook.xposed.prefs.ui.ModulePreferenceFragment
import me.hd.hookmiui13.R

class PrefsFragment : ModulePreferenceFragment() {
    override fun onCreatePreferencesInModuleApp(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.prefs)
    }
}