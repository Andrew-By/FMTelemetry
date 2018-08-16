package com.whlr.fmtelemetry.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import java.net.InetAddress

class AddressesAdapter(val context: Context) : RecyclerView.Adapter<AddressesAdapter.AddressViewHolder>() {
    class AddressViewHolder(val addrView: TextView) : RecyclerView.ViewHolder(addrView)

    var addresses: List<InetAddress>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder(TextView(context))
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        addresses?.let {
            holder.addrView.text = it[position].toString()
        }
    }

    override fun getItemCount(): Int {
        return addresses?.size ?: 0
    }
}