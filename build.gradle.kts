buildscript {
	repositories {
		google()
		jcenter()
		mavenCentral()
	}

	dependencies {
		classpath(Dependency.Plugin.ANDROID_BUILD_TOOLS)
		classpath(Dependency.Plugin.KOTLIN_GRADLE)
	}
}

allprojects {
	group = "com.github.8itsequence"
	version = "0.0.1"

	repositories {
		google()
		jcenter()
		mavenCentral()
	}
}
