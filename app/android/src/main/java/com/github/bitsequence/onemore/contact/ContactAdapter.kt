package com.github.bitsequence.onemore.contact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.github.bitsequence.onemore.R

import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(
		private val ctx: Context,
		private val contacts: ArrayList<Contact>
) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
		val itemView = LayoutInflater
				.from(parent.context)
				.inflate(R.layout.item_contact,
						parent,
						false)
		return ContactHolder(itemView)
	}

	override fun getItemCount(): Int = contacts.size

	override fun onBindViewHolder(holder: ContactHolder, position: Int) {
		contacts.apply {
			holder.displayName.text = contacts[position].displayName
			holder.phoneNumber.text = contacts[position].phoneNumber
		}
	}

	class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
		internal val displayName = view.tvContactDisplayName
		internal val phoneNumber = view.tvContactPhoneNumber
	}

}