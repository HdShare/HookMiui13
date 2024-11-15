package me.hd.hookmiui13.data

import com.highcapable.yukihookapi.hook.xposed.prefs.data.PrefsData

object PrefsData {
    val BLOCK_UPDATE = PrefsData("BlockUpdate", false)
    val REMOVE_WAIT = PrefsData("RemoveWait", false)
    val REMOVE_MENU_AND_BTN = PrefsData("RemoveMenuAndBtn", false)
    val REMOVE_OPEN_ADS = PrefsData("RemoveOpenAds", false)
}