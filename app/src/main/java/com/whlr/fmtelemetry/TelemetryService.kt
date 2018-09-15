package com.whlr.fmtelemetry

import com.whlr.fmtelemetry.models.Telemetry
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.nio.ByteBuffer
import java.nio.ByteOrder

class TelemetryService : Runnable {
    private val sock = DatagramSocket(8888)

    private var buff = ByteArray(232)
    private var packet = DatagramPacket(buff, 0, 232)

    var canRun = true

    var OnTelemetryUpdated: ((Telemetry) -> Unit)? = null

    override fun run() {
        while (canRun) {
            sock.receive(packet)
            OnTelemetryUpdated?.let{
                it.invoke(Telemetry(ByteBuffer.wrap(packet.data).order(ByteOrder.LITTLE_ENDIAN)))
            }
        }
    }
}