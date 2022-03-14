package com.beok.context_receiver_sample

context(Comparator<A>)
fun <A> List<A>.sort(): List<A> =
    sortedWith(this@Comparator)
