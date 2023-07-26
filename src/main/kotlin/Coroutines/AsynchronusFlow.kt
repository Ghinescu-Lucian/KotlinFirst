package Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
//import kotlinx.coroutines.flow.internal.NopCollector.emit
//import java.lang.RuntimeException
import kotlin.system.measureTimeMillis

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


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

fun simple3(): Flow<Int> = flow{
////    println("Flow started")
//    for( i in 1..3){
////        delay(100)
////        println("Emitting $i")
//        emit(i)// emit next value
//    }

    // The WRONG way to change context for CPU-consuming code in flow builder
   // kotlinx.coroutines.withContext(Dispatchers.Default) {
        for (i in 1..3) {
            //Thread.sleep(100) // pretend we are computing it in CPU-consuming way
           // println("Emitting $i")
            delay(100)
            emit(i) // emit next value
        }
}//.flowOn(Dispatchers.Default)

fun simple4(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}
//        .map { value ->
//            check(value <= 1) { "Crashed on $value" }
//            "string $value"
//        }

fun simple(): Flow<Int> = (1..3).asFlow()

fun simple6(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}
suspend fun performRequest(request: Int): String{
    delay(1000) // immitate long-running asynchronous work
    return "Response $request"
}

fun numbers(): Flow<Int> = flow{
    try{
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    }finally{
        println("Finally in numbers")
    }
}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500) // wait 500 ms
    emit("$i: Second")
}

fun events(): Flow<Int> = (1..3).asFlow().onEach{ delay(100)}

fun foo(): Flow<Int> =flow{
    for(i in 1..5){
        println("Emitting $i")
        emit(i)
    }
}
fun main() = runBlocking<Unit>{

//    Flow cancelltion checks
//    Busy flow cancellable

    (1..5).asFlow().cancellable().collect { value ->
        if (value == 3) cancel()
        println(value)
    }

//    (1..5).asFlow().collect{
//        value -> if( value == 3) cancel()
//        println(value)
//    }

//    foo().collect{value ->
//        if(value == 3) cancel()
//        println(value)
//    }

////    Launching flow
//    events()
//        .onEach{ event -> println("Event: $event")}
////        .collect()
//        .launchIn(this) // launching the flow in a separate coroutine
//    println("Done")



//    Flow completion
// Imperative
//    try{
//        simple().collect { value -> println(value) }
//    }finally {
//        println("Done")
//    }

//    Declarative
//    simple()
//        .onCompletion { cause -> if (cause != null) println("Flow completed exceptionally") }
//        .catch { cause -> println("Caught exception") }
//        .collect { value -> println(value) }

//    Successful completion

//    simple()
//        .onCompletion { cause -> println("Flow completed with $cause")}
//        .collect { value ->
//            check( value <= 1){ " Collected $value"}
//            println(value)
//        }

//    Flow exceptions

//    try {
//        simple()
//            .onEach { value ->
//                check(1>= value) {"Collected $value"}
//            println(value)
//             }
//            .catch { e -> println("Caught $e")} // does not catch downstrea
//            .collect()
//    } catch (e: Throwable) {
//        println("Caught $e")
//    }

//    simple()
//        .onEach { value ->
//            check(value <= 1) { "Collected $value" }
//            println(value)
//        }
//        .catch { e -> println("Caught $e") }
//        .collect()


//    Flattening flows
//    (1..3).asFlow().map{ requestFlow(it)}
    // flatMapConcat
//    val startTime = System.currentTimeMillis() // remember the start time
//    (1..3).asFlow().onEach{ delay(100)} // emit a number every 100 ms
//        .flatMapConcat { requestFlow(it)}
//        .collect{ value -> println("$value at ${System.currentTimeMillis()-startTime} ms from beginning")}

    // flatMapMerge
//    val startTime = System.currentTimeMillis()
//    (1..3).asFlow().onEach { delay(100) }
//        .flatMapMerge { requestFlow(it) }
//        .collect { value -> println("$value at ${System.currentTimeMillis()-startTime} ms from beginning")}

    // flatMapLatest
//    val startTime = System.currentTimeMillis() // remember the start time
//    (1..3).asFlow().onEach { delay(100) } // a number every 100 ms
//        .flatMapLatest { requestFlow(it) }
//        .collect { value -> // collect and print
//            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
//        }

//    Composing multiple flows
    //Zip
//    val nums = (1..3).asFlow() // number 1..3
//    val strs = flowOf("one","two","three") // strings
//    nums.zip(strs) { a,b -> "$a -> $b"} // compose single string
//        .collect{println(it)} // collect and print

//    // Combine
//    val nums = (1..3).asFlow().onEach { delay(300) } // numbers 1..3 every 300 ms
//    val strs = flowOf("one", "two", "three").onEach { delay(400) } // strings every 400 ms
//    val startTime = System.currentTimeMillis() // remember the start time
//    nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string with "zip"
//        .collect { value -> // collect and print
//            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
//        }


//    Conflation
    // process only most recent values

//    val time = measureTimeMillis{
//        simple()
//           // .conflate() // conflate
//            .collectLatest{
//                value ->
//                delay(300) // pretend we are processing it for 300ms
//                println(value)
//            }
//    }
//    println("Collected in $time ms")

//    Buffering

//    val time = measureTimeMillis {
//        simple().collect { value ->
//            delay(300) // pretend we are processing it for 300 ms
//            println(value)
//        }
//    }
//    println("Collected in $time ms")

//    val time = measureTimeMillis {
//        simple()
//            .buffer() // buffer emissions, don't wait
//            .collect{ value ->
//                delay(300) // pretrn we are processing it for 300 ms
//                println(value)
//            }
//    }
//    println("Collected in $time ms")

//    Flow context
//    withContext(context){
    /*
    Notice how flow { ... } works in the background thread, while collection happens in the main thread
     */
     //   simple().collect { value -> println(value) }
//    }

//    Flows are sequential
//    (1..5).asFlow()
//        .filter{
//            println("Filter $it")
//            it%2==0
//        }
//        .map{
//            println("Map $it")
//            "string $it"
//        }.collect {
//            println("Collect $it")
//        }

//    Terminal flow operators
//    val sum = (1..5).asFlow()
//        .map{ it * it} // square of numbers from 1 to 5
//        .reduce { a,b -> a+b} // sum them (terminal operator)
//    println(sum)

//    Size-limitting operators
//    numbers()
//        .take(2) // take only the first two
//        .collect{ value -> println("$value")}



//    (1..3).asFlow() // a flow of request
//       // .map{ request -> performRequest(request)}
//        .transform { request ->
//                emit("Marking request $request")
//                emit(performRequest( request))
//        }
//        .collect{ response -> println(response)}

//    simple().forEach{ value-> println(value)}
//    launch{
//        for(k in 1..3){
//            println("I'm not blocked $k")
//            delay(100)
//        }
//    }
//    // collect the flow
//    simple().collect{ value -> println(value) }

//    println("Calling simple function...")
//    val flow = simple()
//    println("Calling collect...")
//    flow.collect{ value -> println(value)}
//    println("Calling collet again...")
//    flow.collect{ value -> println(value)}

//    withTimeoutOrNull(250){
//        simple().collect{
//            value -> println(value)
//        }
//    }
//    println("Done")
//
//    (1..3).asFlow().collect{ value -> println(value)}

}
class AsynchronusFlow {
}