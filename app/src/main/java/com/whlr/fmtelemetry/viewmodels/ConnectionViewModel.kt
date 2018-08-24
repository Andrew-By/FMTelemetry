package com.whlr.fmtelemetry.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

class ConnectionViewModel : ViewModel() {
    val interfaces = MutableLiveData<List<InetAddress>>()

    init{
        getAddresses()
    }

    private fun getAddresses() {

        val addrList = mutableListOf<InetAddress>()
        for (iFace in NetworkInterface.getNetworkInterfaces()) {
            Log.d("IP", "Interface: ${iFace.displayName}")
            for (addr in iFace.inetAddresses) {
                if (addr.isSiteLocalAddress && addr is Inet4Address) {
                    addrList.add(addr)
                }
            }
        }
        interfaces.postValue(addrList)

    }
}