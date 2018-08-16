package com.whlr.fmtelemetry.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.whlr.fmtelemetry.TelemetryService
import com.whlr.fmtelemetry.models.Telemetry
import java.net.DatagramSocket
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketAddress
import java.nio.ByteBuffer

class MainViewModel : ViewModel() {

    private val telemetryService = TelemetryService()

    val interfaces
        get() = NetworkInterface.getNetworkInterfaces()

    val telemetry = MutableLiveData<Telemetry>()

    init {
        telemetryService.OnTelemetryUpdated = { telemetry.postValue(it) }
    }

    fun getAddresses() {

        for (iFace in NetworkInterface.getNetworkInterfaces()) {
            Log.d("IP", "Interface: ${iFace.displayName}")
            for (addr in iFace.inetAddresses) {
                if (addr.isSiteLocalAddress && addr is Inet4Address) {
                    Log.d("IP", addr.toString())
                }
            }
        }
    }

    fun start() {
        telemetryService.canRun = true
        val thread = Thread(telemetryService)
        thread.start()
    }

    fun stop() {
        telemetryService.canRun = false
    }
}