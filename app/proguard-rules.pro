-keep class me.hd.hookmiui13.hook.Entry
-keep class com.highcapable.yukihookapi.** {*;}

-obfuscationdictionary obf-dict.txt
-classobfuscationdictionary obf-dict.txt
-packageobfuscationdictionary obf-dict.txt

-allowaccessmodification
-overloadaggressively
-repackageclasses 'me.hd.hookmiui13.obf'
