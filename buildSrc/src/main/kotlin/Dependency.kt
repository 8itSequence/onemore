@file:Suppress("SpellCheckingInspection")

object Dependency {

	object Android {
		const val MATERIAL = "com.google.android.material:material:${Version.Android.MATERIAL}"

		object X {
			val appcompatV7 = androidx("appcompat:appcompat", Version.Android.X.APP_COMPAT_V7)
			val core = androidx("core:core-ktx", Version.Android.X.CORE_KTX)
			val constraintLayout = androidx("constraintlayout:constraintlayout", Version.Android.X.CONSTRAINT_LAYOUT)
			val drawable = androidx("vectordrawable:vectordrawable", Version.Android.X.VECTOR_DRAWABLE)
			val drawableAnim = androidx("vectordrawable:vectordrawable-animated", Version.Android.X.VECTOR_DRAWABLE_ANIM)

			object Test {
				val espresso = androidxTest("espresso:espresso-core", Version.Android.X.Test.ESPRESSO_CORE)
				val ext = androidxTest("ext:junit", Version.Android.X.Test.EXT_JUNIT)
			}
		}
	}

	object JUnit {
		const val JUNUT_4: String = "junit:junit:${Version.JUnit.JUNIT_4}"
	}

	object Kotlin {
		val stdLib = kotlin("stdlib")
		val stdLib8 = kotlin("stdlib-jdk8")

		object X {
			val coroutines = kotlinx("coroutines-core")
		}
	}

	object Plugin {
		const val ANDROID_BUILD_TOOLS: String = "com.android.tools.build:gradle:${Version.Plugin.ANDROID_BUILD_TOOLS}"
		const val KOTLIN_GRADLE: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin.stdLib}"
	}

	//#############################################################################################
	//### Helpers
	//#############################################################################################

	fun androidx(module: String, version: String? = Version.Android.X.CORE_KTX): String =
			"androidx.$module${version?.let { ":$version" } ?: ""}"

	fun androidxTest(module: String, version: String? = Version.Android.X.Test.ESPRESSO_CORE): String =
			"androidx.test.$module${version?.let { ":$version" } ?: ""}"

	fun kotlin(module: String, version: String? = Version.Kotlin.stdLib8): String =
			"org.jetbrains.kotlin:kotlin-$module${version?.let { ":$version" } ?: ""}"

	fun kotlinx(module: String, version: String? = Version.Kotlin.X.coroutines): String =
			"org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"
}