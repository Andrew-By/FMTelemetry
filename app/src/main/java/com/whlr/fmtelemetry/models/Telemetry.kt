package com.whlr.fmtelemetry.models

import java.nio.ByteBuffer
import java.sql.Timestamp

data class Telemetry(
        var isRaceOn: Boolean,
        var timestampMS: Timestamp,
        var engine: EngineRpm,
        var acceleration: Vector,
        var velocity: Vector,
        var angularVelocity: Vector) {

    constructor(buffer: ByteBuffer) : this(
            if (buffer.getInt() == 1) true else false,
            Timestamp(buffer.getInt().toLong().and(0xFFFFFFFFL)),
            EngineRpm(buffer.slice()),
            Vector(buffer.slice()),
            Vector(buffer.slice()),
            Vector(buffer.slice())
    )
}