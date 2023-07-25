package generics

fun main(){
    genericsExample();
}

fun genericsExample(){
  //  var aquarium = Aquarium<TapWater>(TapWater())
    var aquarium = Aquarium(TapWater())
    println("water processing: ${aquarium.waterSupply.needProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water processing: ${aquarium.waterSupply.needProcessing}")

//    val aquarium2 = Aquarium("string")
//    println(aquarium2.waterSupply)

//    //val aquarium3 = Aquarium(null)
//    if(aquarium3.waterSupply == null){
//        println("waterSupply is null")
//    }

//    val aquarium4 = Aquarium(LakeWater())
//    aquarium4.waterSupply.filter()
//    aquarium4.addWater()

    val aquarium5 = Aquarium(TapWater())
    addItemTo(aquarium5)

//    val cleaner = TapWaterCleaner()
//    val aquarium6 = Aquarium(TapWater())
//    aquarium6.addWater(cleaner)

    val aquarium7 = Aquarium(TapWater())
    isWaterClean(aquarium7)

    val aquarium8 = Aquarium(TapWater())
    println(aquarium.hasWaterSupplyOfType<TapWater>())
    println(aquarium8.waterSupply.isOfType<TapWater>())
}

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun<T: WaterSupply> isWaterClean(aquarium:Aquarium<T>){
    println("Aquarium water is clean: ${!aquarium.waterSupply.needProcessing}")

}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}



class Aquarium<out T:WaterSupply >(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>){
//        check(!waterSupply.needProcessing){ "water supply needs processing first"}
//        println("adding water from $waterSupply")
          if( waterSupply.needProcessing){
              cleaner.clean(waterSupply)
          }
        println("water added")
    }
    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
   // inline fun <reified R: WaterSupply>Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R
}

open class WaterSupply( var needProcessing: Boolean)
class TapWater: WaterSupply(needProcessing = true){
    fun addChemicalCleaners(){
        needProcessing = false
    }
}
class FishStoreWater: WaterSupply(false)
class LakeWater: WaterSupply(true){
    fun filter(){
        needProcessing = false
    }
}