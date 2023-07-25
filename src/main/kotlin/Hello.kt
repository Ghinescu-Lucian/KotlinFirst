import java.util.*

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun feedTheFish(){
    val day = randomDay();
    val food = fishFood(day)
    println("Change water: ${shouldChangeWater(day)}");
    println("Today is $day and the fish eat $food");
}

fun swim(speed: String = "fast"){
    println("swimming $speed")
}

fun fishFood(day: String) : String {
    return when (day) {
        "Monday" ->  "flakes"
        "Tuesday" ->  "pellets"
        "Wednesday" ->  "redworms"
        "Thursday" ->  "granules"
        "Friday" ->  "mosquitoes"
        "Saturday" ->  "lettuce"
        "Sunday" ->  "plankton"
        else ->  "nothing"
    }

}
fun fishFood2(day: String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
    return food
}

fun main(args: Array<String>) {
    val isUnit = println("Hello, ${args[0]}");
    println(isUnit)
    val temperature =10
    val isHot = if(temperature > 50) true else false
    println(isHot);
    val message = "The water is ${if (temperature >5) "too warm" else "OK"}";
    println(message);
    feedTheFish();
    swim();
    swim("slow")
    swim(speed = "turlte-like")

}
fun shouldChangeWater(day:String, temperature: Int =22 , dirty: Int =20):Boolean{
    return when{
        isTooHot(temperature) ->true
        isDirty(dirty) -> true
        isSunday(day)-> true
        else -> false
    }
}
fun randomDay():String{
    val week = arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(week.size)]
}