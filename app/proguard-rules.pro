## Add project specific ProGuard rules here.
## By default, the flags in this file are appended to flags specified
## in C:\Users\c0shan7\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
## You can edit the include path and order by changing the proguardFiles
## directive in build.gradle.
##
## For more details, see
##   http://developer.android.com/guide/developing/tools/proguard.html
#
## Add any project specific keep options here:
#
## If your project uses WebView with JS, uncomment the following
## and specify the fully qualified class name to the JavaScript interface
## class:
##-keepclassmembers class fqcn.of.javascript.interface.for.webview {
##   public *;
##}
#
## Uncomment this to preserve the line number information for
## debugging stack traces.
##-keepattributes SourceFile,LineNumberTable
#
## If you keep the line number information, uncomment this to
## hide the original source file name.
##-renamesourcefileattribute SourceFile
#-optimizationpasses 5
#-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses
#-verbose
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#-dontwarn android.support.**'
#-dontpreverify
#-repackageclasses ''
#-allowaccessmodification
#-keepattributes *Annotation*
#-keepattributes JavascriptInterface
#-keepattributes SourceFile,LineNumberTable
#-useuniqueclassmembernames
#-dontwarn android.os.**
#-dontwarn com.android.internal.**
#-dontwarn com.squareup.**
#-dontwarn android.support.**
#-dontwarn com.google.android.**
#-dontwarn com.google.**
#-dontwarn android.content.pm.**
#
#-renamesourcefileattribute SourceFile
#-keepattributes SourceFile,LineNumberTable
#
#-keep public class * extends android.app.Activity
#-keep public class * extends android.app.Application
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#-keep public class * extends android.app.backup.BackupAgentHelper
#-keep public class * extends android.preference.Preference
#-keep public class com.android.vending.licensing.ILicensingService
#-keepclassmembers class **.R$* {
#    public static <fields>;
#}
#-keep class **.R$*
#-keepattributes *Annotation*
#-dontwarn android.support.v7.**
#-keep class android.support.v7.internal.** { *; }
#-keep interface android.support.v7.internal.** { *; }
#-keep class android.support.v7.** { *; }
#
#-keep class * extends java.util.ListResourceBundle {
#    protected Object[][] getContents();
#}
#
#-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
#    public static final *** NULL;
#}
#
#-keepnames @com.google.android.gms.common.annotation.KeepName class *
#-keepclassmembernames class * {
#    @com.google.android.gms.common.annotation.KeepName *;
#}
#
#-keep public class com.google.android.gms.* { public *; }
#-dontwarn com.google.android.gms.**
#
#-keepnames class * implements android.os.Parcelable {
#    public static final ** CREATOR;
#}
#-keepclassmembers class * {
#   public static native <methods>;
#   private static native <methods>;
#   static native <methods>;
#   private native <methods>;
#   native <methods>;
#}
#
#-keepattributes Signature
#
#-keep class org.apache.http.** { *; }
#-dontwarn org.apache.http.**
#-dontwarn android.net.**