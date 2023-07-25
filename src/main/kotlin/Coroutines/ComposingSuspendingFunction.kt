package Coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class ComposingSuspendingFunction {
}

fun main() = runBlocking(){
    val time = measureTimeMillis{
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one+two}")
    }
}

suspend fun doSomethingUsefulOne():Int{
    delay(1000L) // pretending to do smth useful here
    return 13
}

suspend fun doSomethingUsefulTwo():Int{
    delay(1000L)
    return 29
}