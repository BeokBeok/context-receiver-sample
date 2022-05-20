package com.beok.context_receiver_sample

class AccountRepo {
    fun credit(account: Account, amount: Double) = Unit
    fun debit(account: Account, amount: Double) = Unit
}
