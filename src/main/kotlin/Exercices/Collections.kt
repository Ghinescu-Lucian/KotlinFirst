package Exercices

class Collections {
}

fun main(){
//    Arrays

//    val rockPlanets = arrayOf<String>("Mercury","Earth","Mars","Venus")
//    val gasPlanets = arrayOf("Jupiter", "Saturn", "Neptune","Uranus")
//    val solarSystem = rockPlanets + gasPlanets
//
//   // println(solarSystem)
//    solarSystem[3]= "Little Earth"
//
//   // solarSystem[8]="Pluto" -> i can't resize an array
//    println(solarSystem[0])
//    println(solarSystem[1])
//    println(solarSystem[2])
//    println(solarSystem[3])
//    println(solarSystem[4])
//    println(solarSystem[5])
//    println(solarSystem[6])
//    println(solarSystem[7])

//    Lists

//    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem.size) // fara () la size
//    println(solarSystem[2])
//    println(solarSystem[3])
//    println(solarSystem.indexOf("Earth"))
//    println(solarSystem.indexOf("Pluto"))
//
//    for(planet in solarSystem){
//        println(planet)
//    }
//
//    solarSystem.add("Pluto")
//    solarSystem.add(3, "Theia")
//    for(planet in solarSystem){
//        println(planet)
//    }
//    solarSystem.remove("Future Moon")
//    solarSystem.remove("Pluto")
//    println(solarSystem.contains("Pluto"))
//    println("Future Moon" in solarSystem)

//    Sets

    // searching is realy fast in sets
    // but tend to use more memory
//    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem.size)
//    solarSystem.add("Pluto")
//    println(solarSystem.size)
//    println(solarSystem.contains("Pluto"))
//    solarSystem.add("Pluto")
//    println(solarSystem.size)
//    solarSystem.remove("Pluto")
//    println(solarSystem.size)
//    println(solarSystem.contains("Pluto"))

//    Map
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystem.size)
    solarSystem["Pluto"] = 5
    println(solarSystem.size)
    println(solarSystem["Pluto"])
    println(solarSystem.get("Theia"))
    solarSystem.remove("Pluto")
    println(solarSystem.size)
    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}