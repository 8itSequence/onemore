package com.github.bitsequence.onemore

import android.Manifest
import android.os.Bundle
import android.provider.ContactsContract

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.recyclerview.widget.LinearLayoutManager

import com.github.bitsequence.onemore.contact.Contact
import com.github.bitsequence.onemore.contact.ContactAdapter

import kotlinx.android.synthetic.main.content_contacts.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val contacts = ArrayList<Contact>()
		if (ContextCompat.checkSelfPermission(
						this,
						Manifest.permission.READ_CONTACTS) != PermissionChecker
						.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(
					this,
					arrayOf(Manifest.permission.READ_CONTACTS),
					100)
		} else {
			readContacts(contacts)
		}

		rvContacts.adapter = ContactAdapter(applicationContext, contacts)
		val layoutManager = LinearLayoutManager(applicationContext)
		layoutManager.orientation = LinearLayoutManager.VERTICAL
		rvContacts.layoutManager = layoutManager
	}

	private fun readContacts(contacts: ArrayList<Contact>) {
		val contactCursor = contentResolver.query(
				ContactsContract.Contacts.CONTENT_URI,
				null,
				null,
				null,
				null)
		if (contactCursor != null && contactCursor.moveToFirst()) {
			do {
				val contactId = contactCursor.getString(contactCursor
						.getColumnIndex(ContactsContract
								.Contacts
								._ID))

				val displayName = contactCursor.getString(contactCursor
						.getColumnIndex(ContactsContract
								.Contacts
								.DISPLAY_NAME))
				val contact = Contact(contactId, displayName)

				val phoneNumber:  String?
				if (contactCursor.getInt(contactCursor
								.getColumnIndex(ContactsContract
										.Contacts
										.HAS_PHONE_NUMBER)) > 0) {
					val phoneCursor = contentResolver.query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
							arrayOf(contactId),
							null)
					phoneCursor?.moveToNext()
					phoneNumber = phoneCursor?.getString(phoneCursor
							.getColumnIndex(ContactsContract
									.CommonDataKinds
									.Phone
									.NUMBER))
					phoneCursor?.close()
				} else {
					phoneNumber = null
				}
				contacts.add(contact.copy(phoneNumber = phoneNumber))
			} while (contactCursor.moveToNext())
		}

		contactCursor?.close()
	}

}