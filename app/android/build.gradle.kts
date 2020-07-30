plugins {
	id("com.android.application")
	kotlin("android")
	id("kotlin-android-extensions")
}

android {
	compileSdkVersion(Version.Android.Sdk.COMPILE)
	buildToolsVersion(Version.Android.Sdk.BUILD)

	defaultConfig {
		applicationId = "com.github.bitsequence.onemore"
		minSdkVersion(Version.Android.Sdk.MIN_SDK)
		targetSdkVersion(Version.Android.Sdk.TARGET_SDK)
		versionCode = 1
		versionName = "0.0.1"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables.useSupportLibrary = true
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(Dependency.Kotlin.stdLib8)

	implementation(Dependency.Android.MATERIAL)

	implementation(Dependency.Android.X.appcompatV7)
	implementation(Dependency.Android.X.constraintLayout)
	implementation(Dependency.Android.X.core)
	implementation(Dependency.Android.X.drawable)
	implementation(Dependency.Android.X.drawableAnim)

	testImplementation(Dependency.JUnit.JUNUT_4)

	androidTestImplementation(Dependency.Android.X.Test.ext)
	androidTestImplementation(Dependency.Android.X.Test.espresso)
}