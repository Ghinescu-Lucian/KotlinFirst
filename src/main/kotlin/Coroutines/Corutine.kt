package Coroutines

import kotlinx.coroutines.*

class Corutine {
}

//fun main() = runBlocking{
////    val job = launch{
////        delay(1000L)
////        println("World!")
////    }
////    doWorld()
////    job.join() // wait for the child coroutine to complete
////    println("Hello")
//
////    val job = launch {
////        try{
////           val result =  withTimeout(1300L) {
////                repeat(1000) { i ->
////                    println("job: I'm sleeping $i...")
////                    delay(500L)
////                }
////            }
////        }finally{
////            withContext(NonCancellable){
////                println("job: I'm running finally")
////                delay(1000L)
////                println("And I've just delayed for 1 sec because I'm non-cancellable")
////            }
////
////        }
////    }
////    delay(  3300L)
////    println("I'm tired of waitting!")
////    job.cancel()
////    job.join()// waits for job's completion
////    println("main: Now I can quit.")
//
////    CooperativeCancellation()
//
//    val result = withTimeoutOrNull(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//        "Done"
//    }
//
//    println("Result is: $result")
//
//}



var acquired = 0
class Resource{
    init{ acquired++} // Acquire the resource
    fun close() { acquired --} // Release the resource
}

fun main(){
    runBlocking{
        repeat(10_000){
            launch{
                var resource: Resource? = null
                try {
                    withTimeout(60) {
                        delay(50)
                        resource = Resource()
                    }
                    // We can do something else with the resource here
                }finally {
                    resource?.close() // Release the resource if it was acquired
                }
            }
        }
    }
    println(acquired)
}


suspend fun doWorld() = coroutineScope {
    launch{
        delay(1000L)
        println("Ceva")
    }
    launch{
        delay(2000L)
        println("World 2")
    }
    println("Altceva")
}

suspend fun CooperativeCancellation() = coroutineScope{
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default){
        var nextPrintTime = startTime
        var i = 0
        while(isActive){
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of  waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}