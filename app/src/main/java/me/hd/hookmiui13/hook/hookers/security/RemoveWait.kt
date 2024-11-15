package me.hd.hookmiui13.hook.hookers.security

import android.os.Message
import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.type.java.IntType
import me.hd.hookmiui13.data.PrefsData
import me.hd.hookmiui13.hook.utils.DexKitUtil
import org.luckypray.dexkit.query.enums.MatchType
import java.lang.ref.WeakReference
import java.lang.reflect.Modifier

object RemoveWait : YukiBaseHooker() {
    override fun onHook() {
        if (!prefs.get(PrefsData.REMOVE_WAIT)) return
        DexKitUtil.create(this) {
            findClass {
                findFirst = true
                searchPackages("com.miui.permcenter.privacymanager")
                matcher {
                    fields {
                        addForType(Int::class.java)
                        addForType(WeakReference::class.java)
                        count = 2
                    }
                    methods {
                        add {
                            modifiers = Modifier.PUBLIC
                            name = "handleMessage"
                            returnType = "void"
                            paramTypes(Message::class.java)
                        }
                        add {
                            paramCount(0)
                            invokeMethods {
                                add {
                                    name = "sendEmptyMessageDelayed"
                                }
                                matchType = MatchType.Contains
                            }
                            usingNumbers(1, 1000L)
                        }
                    }
                }
            }.single().getInstance(appClassLoader!!).method {
                param(IntType)
                returnType(Void.TYPE)
            }.hook {
                before {
                    args[0] = 0
                }
            }
        }
    }
}