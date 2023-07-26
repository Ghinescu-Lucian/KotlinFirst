package Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import java.rmi.server.LogStream.log
import kotlin.system.measureTimeMillis

class ComposingSuspendingFunction {
}

/*

    With async the result is obtained twice as fast than sequentially

 */

class Activity{
    private val mainScope = CoroutineScope(Dispatchers.Default)

    fun destroy(){
        mainScope.cancel()
    }

    fun doSomething(){
        // launch ten routines, each work for a different time

        repeat(10){ i ->
            mainScope.launch{
                delay((i+1)*200L)
            println("Courutine $i is done")
        }
        }

    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")



val threadLocal = ThreadLocal<String?>() // declare thread-local variable
fun main() = runBlocking<Unit>() {
//sampleStart

    val activity = Activity()
    activity.doSomething()
    println("Launched coroutines")
    delay(500L)
    println("Destroying activity")
    activity.destroy()
    delay(1000)

    threadLocal.set("main")
    println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
        println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
        yield()
        println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    }
    job.join()
    println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")

//    newSingleThreadContext("Ctx1").use { ctx1 ->
//        newSingleThreadContext("Ctx2").use { ctx2 ->
//            runBlocking(ctx1) {
//                log("Started in ctx1")
//                withContext(ctx2) {
//                    log("Working in ctx2")
//                }
//                log("Back to ctx1")
//            }
//        }
//    }
//    println("My job is ${coroutineContext[Job]}")
    // launch a coroutine to process some kind of incoming request
//    val request = launch {
//        // it spawns two other jobs
//        launch(Job()) {
//            println("job1: I run in my own Job and execute independently!")
//            delay(1000)
//            println("job1: I am not affected by cancellation of the request")
//        }
//        // and the other inherits the parent context
//        launch {
//            delay(100)
//            println("job2: I am a child of the request coroutine")
//            delay(1000)
//            println("job2: I will not execute this line if my parent request is cancelled")
//        }
//    }
//    delay(500)
//    request.cancel() // cancel processing of the request
//    println("main: Who has survived request cancellation?")
//    delay(1000) // delay the main thread for a second to see what happens


//    val request = launch {
//        repeat(3) { i -> // launch a few children jobs
//            launch  {
//                delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
//                println("Coroutine $i is done")
//            }
//        }
//        println("request: I'm done and I don't explicitly join my children that are still active")
//    }
//    request.join() // wait for completion of the request, including all its children
//    println("Now processing of the request is complete")
//
//    log("Started main coroutine")
//// run two background value computations
//    val v1 = async(CoroutineName("v1coroutine")) {
//        delay(500)
//        log("Computing v1")
//        252
//    }
//    val v2 = async(CoroutineName("v2coroutine")) {
//        delay(1000)
//        log("Computing v2")
//        6
//    }
//    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
//
//
//    launch(Dispatchers.Default + CoroutineName("test")) {
//        println("I'm working in thread ${Thread.currentThread().name}")
//    }

//sampleEnd
}
/*
fun main() = runBlocking<Unit>(){
//    val time = measureTimeMillis{
//        val one = async ( start = CoroutineStart.LAZY) {doSomethingUsefulOne()}
//        val two = async ( start  = CoroutineStart.LAZY){doSomethingUsefulTwo()}
//        /* Lazy start = pot sa dau strat oricand vreau eu in cod, nu doar la declarare */
//        one.start() // start the first one
//        two.start() // strat the seconde one
//        println("The answer is ${one.await()+two.await()}")
//    }
//    println("Completed in $time msr")

//    val time = measureTimeMillis {
//        // we can initiate async actions outside of a coroutine
//        val one = somethingUsefulOneAsync()
//        val two = somethingUsefulTwoAsync()
//        // but waiting for a result must involve either suspending or blocking.
//        // here we use `runBlocking { ... }` to block the main thread while waiting for the result
//        runBlocking {
//            println("The answer is ${one.await() + two.await()}")
//        }
//    }
//    println("Completed in $time ms")

//    val time = measureTimeMillis {
//        println("The answer is ${concurrentSum()}")
//    }
//    println("Completed in $time ms")

//    launch { // context of the parent, main runBlocking coroutine
//        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
//        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
//        println("Default               : I'm working in thread ${Thread.currentThread().name}")
//    }
//    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
//        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
//    }

//    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
//        println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
//        delay(500)
//        println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
//    }
//    launch { // context of the parent, main runBlocking coroutine
//        println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
//        delay(1000)
//        println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
//    }
    val a = async {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async {
        log("I'm computing another piece of the answer")
        7
    }
    log("The answer is ${a.await() * b.await()}")



}*/

suspend fun doSomethingUsefulOne():Int{
    delay(1000L) // pretending to do smth useful here
    return 13
}

suspend fun doSomethingUsefulTwo():Int{
    delay(1000L)
    return 29
}


// cele doua functii de mai jos nu sunt suspending functions, dar ele se executa concurent cu codul
@OptIn(DelicateCoroutinesApi:: class)
fun somethingUsefulOneAsync() = GlobalScope.async{
    doSomethingUsefulOne()
}

@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulTwoAsync() = GlobalScope.async{
    doSomethingUsefulTwo()
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async{ doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await()+two.await()
}