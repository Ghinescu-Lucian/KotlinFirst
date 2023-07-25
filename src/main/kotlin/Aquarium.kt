//class Aquarium (length: Int = 100, width: Int = 20, height: Int = 40){
//    var width: Int = width
//    var height: Int = height
//    var length: Int = length
//
//    fun printSize(){
//        println("Width: $width cm" +
//                "Length: $length cm"+
//                "Height: $height cm"
//                )
//    }
//}
import java.lang.Math
import kotlin.math.PI

open class Aquarium (open var length: Int = 100,open var width: Int = 20,open var height: Int = 40) {

    open var volume: Int
        get() = width*height*length/1000
        set(value){
            height = (value*1000)/ (width*length)

        }

    open val shape: String = "rectangle"
    open var water: Double = 0.0
        get() = 0.9 *volume
    init {
        println("aquarium initializing")
    }
//    init {
//        // 1 liter = 1000 cm^3
//        println("Volume: ${width * length * height / 1000} l")
//    }

    constructor(numberOfFish: Int): this(){
        val tank = numberOfFish*2000*1.1

        // calculate the height needed
        height = (tank / (length*width)).toInt()
    }

    fun printSize(){
        println("Width: $width cm " +
                "Length: $length cm "+
                "Height: $height cm "
                )
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}

class TowerTank( override var height: Int, var diameter:Int) : Aquarium(height = height, width = diameter, length = diameter){

        override var volume: Int
        // ellipse ara = pie * r1 *r2
        get() = (width/2 * length/2 * height/1000* PI).toInt()
        set(value){
                height = ((value*100/PI)/(width/2*length/2)).toInt()
            }
        override var water = volume*0.8
        override val shape = "cylinder"

}

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim()  {
        println("swim")
    }
}