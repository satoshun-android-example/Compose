package dependencies

const val COMPILE_SDK = 29
const val MIN_SDK = 25
const val TARGET_SDK = 29

private const val VKOTLIN = "1.3.71"

const val ANDROID_PLUGIN = "com.android.tools.build:gradle:4.2.0-alpha04"
const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VKOTLIN"

const val VUIVERSION = "0.1.0-dev06"

// private const val VUIVERSION = "0.1.0-SNAPSHOT"
const val COMPOSE = "androidx.compose:compose-runtime:$VUIVERSION"
const val UI_TOOLING = "androidx.ui:ui-tooling:$VUIVERSION"
const val UI_LAYOUT = "androidx.ui:ui-layout:$VUIVERSION"
const val UI_MATERIAL = "androidx.ui:ui-material:$VUIVERSION"
const val UI_ANIMATION = "androidx.ui:ui-animation:$VUIVERSION"
const val UI_PLATFORM = "androidx.ui:ui-platform:$VUIVERSION"
const val UI_MATERIAL_ICON = "androidx.ui:ui-material-icons-core:$VUIVERSION"
const val UI_MATERIAL_ICON_EXTENDED = "androidx.ui:ui-material-icons-extended:$VUIVERSION"
const val UI_VECTOR = "androidx.ui:ui-vector:$VUIVERSION"
const val UI_GRAPHICS = "androidx.ui:ui-graphics:$VUIVERSION"
const val UI_UTIL = "androidx.ui:ui-util:$VUIVERSION"
const val UI_FRAMEWORK = "androidx.ui:ui-framework:$VUIVERSION"

const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$VKOTLIN"

private const val VCOUROUTINE = "1.3.3"
const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VCOUROUTINE"
const val UI_COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VCOUROUTINE"

const val KTX = "androidx.core:core-ktx:1.1.0"
const val ACTIVITYX = "androidx.activity:activity-ktx:1.1.0"
const val FRAGMENTX = "androidx.fragment:fragment-ktx:1.2.0"

const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:2.2.0"
const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"

const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.1.0-beta04"
const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.0-beta3"
const val CARDVIEW = "androidx.cardview:cardview:1.0.0"

const val DESUGAR = "com.android.tools:desugar_jdk_libs:1.0.4"

const val CONTENTPAGER = "androidx.contentpager:contentpager:1.0.0-rc01"
const val WEBKIT = "androidx.webkit:webkit:1.0.0"
const val MEDIA2 = "androidx.media2:media2:1.0.0-alpha04"

const val MATERIAL = "com.google.android.material:material:1.1.0-beta02"
const val PAGING = "androidx.paging:paging-runtime:2.1.0"
const val BROWSER = "androidx.browser:browser:1.0.0"

private const val VROOM = "2.1.0-alpha04"
const val ROOM_COMMON = "androidx.room:room-common:$VROOM"
const val ROOM_RUNTIME = "androidx.room:room-runtime:$VROOM"
const val ROOM_COMPILER = "androidx.room:room-compiler:$VROOM"

const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0-alpha03"
const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.1.0-alpha03"
const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:2.0.0"
const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:2.1.0-alpha03"

const val BIOMETRIC = "androidx.biometric:biometric:1.0.0-alpha03"

const val EMOJI = "androidx.emoji:emoji:1.0.0"
const val EMOJI_COMPAT = "androidx.emoji:emoji-appcompat:1.0.0"
const val EMOJI_BUNDLED = "androidx.emoji:emoji-bundled:1.0.0"

const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

const val SAVEDSTATE = "androidx.savedstate:savedstate:1.0.0-alpha02"
const val SAVEDSTATE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01"

const val VIEWPAGER2 = "androidx.viewpager2:viewpager2:1.0.0-alpha01"

const val RECOMMENDATION = "androidx.recommendation:recommendation:1.0.0"

const val PREFERENCE = "androidx.preference:preference-ktx:1.1.0-alpha03"

const val MULTIDEX = "androidx.multidex:multidex:2.0.0"

const val RXWEBVIEW = "com.github.satoshun.RxWebView:rxwebview-kotlin:2.3.0"

const val RXJAVA = "io.reactivex.rxjava2:rxjava:2.2.0"
const val RXANDROID = "io.reactivex.rxjava2:rxandroid:2.1.0"

const val GROUPIE = "com.xwray:groupie:2.6.0"
const val GROUPIE_DATABINDING = "com.xwray:groupie-databinding:2.6.0"

const val WORK_MANAGER = "androidx.work:work-runtime-ktx:2.0.0-rc01"

const val ANDROID_ANNOTATION = "androidx.annotation:annotation:1.0.0"

private const val VDAGGER = "2.22.1"
const val DAGGER_RUNTIME = "com.google.dagger:dagger:$VDAGGER"
const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:$VDAGGER"
const val DAGGER_ANDROID_RUNTIME = "com.google.dagger:dagger-android:$VDAGGER"
const val DAGGER_ANDROID_COMPILER = "com.google.dagger:dagger-android-processor:$VDAGGER"
const val DAGGER_ANDROID_SUPPORT_RUNTIME = "com.google.dagger:dagger-android-support:$VDAGGER"

const val COIL = "io.coil-kt:coil:0.9.5"

const val JUNIT = "junit:junit:4.13-beta-1"
const val TRUTH = "com.google.truth:truth:0.42"
const val MOCKITO_KOTLIN = "com.nhaarman:mockito-kotlin-kt1.1:1.5.0"
const val TEST_RUNNER = "androidx.test:runner:1.1.1"
const val TEST_RULE = "androidx.test:rules:1.1.0"
const val ESPRESSO = "androidx.test.espresso:espresso-core:3.1.1"

const val OKHTTP = "com.squareup.okhttp3:okhttp:4.2.1"
const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:4.2.1"
const val RETROFIT = "com.squareup.retrofit2:retrofit:2.6.2"
