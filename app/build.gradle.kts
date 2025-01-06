plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.dspread_yoshi_basic_use_case"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.dspread_yoshi_basic_use_case"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {

        create("release") {
            keyAlias = "yoshi"
            keyPassword = "yoshipos"
            storeFile = file("release_keystore")
            storePassword = "yoshipos"
        }

        getByName("debug") {
            keyAlias = "gundam_wing"
            keyPassword = "dspread"
            storeFile = file("app.keystore")
            storePassword = "dspread"
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
            signingConfig?.storeFile = file("app.keystore")
            signingConfig?.storePassword = "dspread"
            signingConfig?.keyPassword = "dspread"
            signingConfig?.keyAlias = "gundam_wing"
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            signingConfig?.storeFile = file("release_keystore")
            signingConfig?.storePassword = "yoshipos"
            signingConfig?.keyPassword = "yoshipos"
            signingConfig?.keyAlias = "yoshi"

            isDebuggable = true
            isJniDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    /***
     * DSPREAD Libraries
     */

    implementation("com.dspread.library:dspread_pos_sdk:6.0.8")
    implementation("com.dspread.print:dspread_print_sdk:1.3.7-beta")
}