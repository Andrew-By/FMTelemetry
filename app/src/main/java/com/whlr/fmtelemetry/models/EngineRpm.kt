package com.whlr.fmtelemetry.models

import java.nio.ByteBuffer

data class EngineRpm(
        var max: Float,
        var idle: Float,
        var current: Float) {

    constructor(buffer: ByteBuffer) : this(
            buffer.getFloat(),
            buffer.getFloat(),
            buffer.getFloat()
    )
}