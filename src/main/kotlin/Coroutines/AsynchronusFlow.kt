package Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

//fun  simple(): List<Int> = listOf(1,2,3)

fun simple1():Sequence<Int> = sequence{
    for( i in 1..3){
        Thread.sleep(1000) // pretend we are computing it
        yield(i)
    }
}

suspend fun simple2():List<Int>{
    delay(1000)
    return listOf(1,2,3)
}

fun simple(): Flow<Int> = flow{
    println("Flow started")
    for( i in 1..3){
        delay(100)
        emit(i)// emit next value
    }
}

fun main() = runBlocking<Unit>{
//    simple().forEach{ value-> println(value)}
//    launch{
//        for(k in 1..3){
//            println("I'm not blocked $k")
//            delay(100)
//        }
//    }
//    // collect the flow
//    simple().collect{ value -> println(value) }

    println("Calling simple function...")
    val flow = simple()
    println("Calling collect...")
    flow.collect{ value -> println(value)}
    println("Calling collet again...")
    flow.collect{ value -> println(value)}

}
class AsynchronusFlow {
}