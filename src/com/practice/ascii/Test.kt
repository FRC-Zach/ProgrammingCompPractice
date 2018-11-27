package com.practice.ascii

val String.isGood: Boolean get() = this.length > 3

fun main(args: Array<String>) {
    println("1234".isGood)
    println("12".isGood)
}