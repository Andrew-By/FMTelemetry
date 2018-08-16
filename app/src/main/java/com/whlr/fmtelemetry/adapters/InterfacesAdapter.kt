package com.whlr.fmtelemetry.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.whlr.fmtelemetry.R
import com.whlr.fmtelemetry.databinding.ItemInterfaceBinding
import java.net.NetworkInterface

class InterfacesAdapter(val context: Context) : RecyclerView.Adapter<InterfacesAdapter.InterfaceViewHolder>() {
    class InterfaceViewHolder(context: Context, val binding: ItemInterfaceBinding) : RecyclerView.ViewHolder(binding.root) {
        val addrAdapter = AddressesAdapter(context)

        init {
            binding.addressesView.adapter = addrAdapter
            binding.addressesView.layoutManager = LinearLayoutManager(context)
        }
    }

    var interfaces: List<NetworkInterface>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterfaceViewHolder {
        val binding: ItemInterfaceBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_interface, parent, false)
        return InterfaceViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: InterfaceViewHolder, position: Int) {
        interfaces?.let {
            val iFace = it[position]
            holder.binding.iface = iFace
            holder.addrAdapter.addresses = iFace.inetAddresses.toList()
        }
    }

    override fun getItemCount(): Int {
        return interfaces?.size ?: 0
    }
}