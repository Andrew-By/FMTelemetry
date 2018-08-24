package com.whlr.fmtelemetry.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.whlr.fmtelemetry.TelemetryService
import com.whlr.fmtelemetry.models.Telemetry
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface

class MainViewModel : ViewModel() {

    private val telemetryService = TelemetryService()

    val telemetry = MutableLiveData<Telemetry>()

    init {
        telemetryService.OnTelemetryUpdated = { telemetry.postValue(it) }
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