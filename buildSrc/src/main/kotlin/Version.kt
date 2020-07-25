object Version {
	object Android {
		object Sdk {
			const val BUILD: String = "30.0.1"
			const val COMPILE: Int = 29                      // https://source.android.com/setup/start/build-numbers
			const val MIN_SDK: Int = 16
			const val TARGET_SDK: Int = 29
		}

		object X {
			const val APP_COMPAT_V7: String = "1.1.0"         // https://mvnrepository.com/artifact/androidx.appcompat/appcompat
			const val CORE_KTX: String = "1.3.0"              // https://mvnrepository.com/artifact/androidx.core/core-ktx

			object Test {
				const val EXT_JUNIT: String = "1.1.1"              // https://mvnrepository.com/artifact/androidx.test.ext/junit
				const val ESPRESSO_CORE: String = "3.2.0"          // https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
			}
		}
	}

	object JUnit {
		const val JUNIT_4: String = "4.13"                      // https://mvnrepository.com/artifact/junit/junit
	}

	object Kotlin {
		const val stdLib: String = "1.3.72"        // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib, https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-gradle-plugin
		const val stdLib8: String = "1.3.72"       // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk8

		object X {
			const val coroutines: String = "1.3.7" // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
		}
	}

	object Plugin {
		const val ANDROID_BUILD_TOOLS: String = "4.0.1" // https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google
	}
}