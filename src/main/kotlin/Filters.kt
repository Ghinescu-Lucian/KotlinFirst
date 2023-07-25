val decorations = listOf ( "rock","pagoda","plastic plant","aligator","flowerpot")
fun main(){
    val eager = decorations.filter { it[0]=='p'}
    println("eager: $eager")
    val filtered = decorations.asSequence().filter { it[0] =='p'}
    println("filtered: $filtered")
    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")
    println(decorations.filter {it[0]=='p'})

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter { it[0]=='p'}.map{
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    var dirtyLevel = 20
    val waterFilter: (Int) -> Int = {dirty: Int -> dirty/2}
    println(waterFilter(dirtyLevel))

}