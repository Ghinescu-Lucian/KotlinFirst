package decor

data class Decoration( val rocks: String){

}

fun makeDecorations(){
    var decoration1 = Decoration("granite")
    println(decoration1)

    var decoration2 = Decoration("slate")
    println(decoration2)

    var decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))

    val d5 = Decoration2("crystal", "woood", "diver")
    println(d5)

    val (rock, _, diver) = d5
    println(rock)
    //println(wood)
    println(diver)




}

data class Decoration2( val rocks: String, val wood: String, val diver: String)

enum class Color(val rgb: Int){
    RED(0xFF0000), GREEN(0x00ff00), BLUE(0x0000FF);
}
enum class Direction(val degrees: Int){
    NORTH(0), SOuth(180), EAST(90), West(270);
}
fun main(){
    makeDecorations()
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

}