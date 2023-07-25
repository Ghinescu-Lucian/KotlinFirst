package Exercices

class KotlinFundamentals
{
}
/* Ex1

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    // Fill in the code.
    var s= ""
    if(numberOfMessages >99) s = "99+"
    else s = numberOfMessages.toString()

    if(s == "99+")
        println("Yout phone is blowing up! You have 99+ notifications.")
    else println("You have 51 notifications.")
}*/

// Ex2
/*
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
    var price = -1
    if(age <=12 ) price =15;
    else if(age>12 && age <= 60){
       if(isMonday) price =25
       else price = 30
    }
    else if(age > 60 && age < 100) price =20

    return price
}

SAU

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}


 */

// Ex3
/*

 printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
 printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
 printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }

 SAU

 fun main() {
    // Fill in the code.
    val cf: (Double) -> Double = {x -> 9.0/5*x +32.0}
    val kc: (Double) -> Double = {x -> x - 273.15}
    val fk: (Double) -> Double = {x -> 5.0/9 * (x-32.0) + 273.15}
    printFinalTemperature(27.0, "Celsius", "Farenheit", cf)
    printFinalTemperature(350.0, "Kelvin", "Celsisus", kc)
    printFinalTemperature(10.0, "Farenheit", "Kelvin", fk)
}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
 */

// ex 5
/*
fun main() {
   val song = Song("a","b",2000,102)
   song.printSong()
}

class Song(var title: String, var artist: String, var year: Int,
           var count: Int){
    var popular: Boolean = if(count < 1000) false else true
 SAU
   val isPopular: Boolean
        get() = playCount >= 1000

    fun printSong(){
        println("${title}, performed by ${artist}, was released in ${year}\n and is popular:${popular}.")
    }
}
 */
// ex 6
/*
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
       // Fill in code
        print("Name: ${name}\n"+
                "Age: ${age}\n"+
                "Likes to ${hobby}.")
        if(referrer != null)
        	print(" Has a referrer named ${referrer.name},")
        	if( referrer.hobby != null ) print(" who likes to ${referrer.hobby}.")
        	else print(".")
        else print(" Doesn't have a referrer.")
    }
}
 */

// ex 7
/*
fun main(){
    val fold = FoldablePhone( isFolded = true)
    fold.switchOn()
    fold.checkPhoneScreenLight()
    fold.isFolded = false
    fold.switchOn()
    fold.checkPhoneScreenLight()
}
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = false): Phone(false){
    override fun switchOn(){
        if(isFolded == false)
        	isScreenLightOn = true
        else isScreenLightOn = false
    }
    fun fold(){
        isFolded = !isFolded
    }
}f

 */

//8
/*
fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
   // Fill in the code.
    if(bid == null) return minimumPrice
    else return bid.amount

    SAU
    return bid?.amount ?: minimumPrice
}
 */