package com.whlr.fmtelemetry.models

import java.nio.ByteBuffer

data class Vector(
        var x: Float,
        var y: Float,
        var z: Float) {

    constructor(buffer: ByteBuffer) : this(
            buffer.getFloat(),
            buffer.getFloat(),
            buffer.getFloat()
    )
}