package Exercices

import kotlin.math.PI
import kotlin.math.sqrt

class Classes_Inheritance {
}

fun main(){
    // val dwelling = Dwelling() -> error abstract calss cannot be instatiated
    val squareCabin = SquareCabin(5, 60.0)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
    }

    val roundHut = RoundHut(3, 10.0)

    with(roundHut){
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet Length: ${calculateMaxCarpetLength()}")
    }

    val roundTower = RoundTower(residents = 4, radius = 15.5)

    with(roundTower){
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet Length: ${calculateMaxCarpetLength()}")
    }

}

abstract class Dwelling(private var residents:Int){
    abstract val buildingMaterial: String
    abstract val capacity: Int


    fun hasRoom(): Boolean{
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom(){
        if (capacity > residents){
            residents++
            println("You got a room!")
        }else {
            println("Sorry, at capacity and no room left.")
        }
    }



}

class SquareCabin(residents:Int, var length: Double): Dwelling(residents){

    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea():Double{
        return length*length
    }

}

open class RoundHut(residents: Int, private val radius : Double): Dwelling(residents){

    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea():Double{
        return PI*radius*radius
    }

    fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
    }

}

class RoundTower(val floors: Int=2, radius: Double, residents: Int): RoundHut(residents, radius){

    override val buildingMaterial = "Stone"
    override val capacity = 4*floors

    override fun floorArea():Double{
        val r = super.floorArea()
        return floors*r
    }

}
