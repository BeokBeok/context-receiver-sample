package com.beok.context_receiver_sample

import java.util.logging.Logger

interface LoggingContext {
    val log: Logger
}

context(LoggingContext)
fun startBusinessOperation() {
    log.info("Operation has started")
}

fun test(loggingContext: LoggingContext) {
    with(loggingContext) {
        startBusinessOperation()
    }
}
