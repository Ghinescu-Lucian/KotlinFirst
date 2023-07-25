package example

data class Fish(var name: String) {
}
fun fishExamples(){
    val fish = Fish("splashy")
    myWith(fish.name){
        println(this.capitalize())
    }

    fish.run { name }

    val fish2 = Fish("splashy").apply{
        name =  "sharky"
    }
    println(fish2.name)

    println(fish.let{ it.name.capitalize()}
        .let{it + "fish"}
        .let{it.length}
        .let{it+31}
    )
    println(fish)

}

inline fun myWith(name : String, block: String.() -> Unit) {
   name.block()
}

fun runExample(){
//    val runnable = object: Runnable{
//        override fun run() {
//            println("I'm a Runnable")
//        }
//    }
//    JavaRun.runNow(runnable)
    JavaRun.runNow{
        println("Passing a lambda as a Runnable")
    }
}

fun main(){
//    fishExamples()
    runExample()
}