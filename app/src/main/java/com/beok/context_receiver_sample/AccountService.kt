package com.beok.context_receiver_sample

class AccountService {
    context(Transaction)
    fun transfer(vararg operations: () -> Unit) {
        start()
        try {
            operations.forEach { it.invoke() }
            commit()
        } catch (e: Exception) {
            rollback()
        }
    }
}
