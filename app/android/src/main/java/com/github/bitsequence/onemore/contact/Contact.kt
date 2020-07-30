package com.github.bitsequence.onemore.contact

import java.io.Serializable

data class Contact(
		val id: String,
		val displayName: String,
		val phoneNumber: String? = null
) : Serializable