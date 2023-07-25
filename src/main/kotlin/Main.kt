import javax.swing.RootPaneContainer

fun main(args: Array<String>) {
//    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//    buildAquarium()

    makeFish()

}

fun buildAquarium(){
    /*val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()*/

    /*val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()*/

    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()

    val towerTank = TowerTank(diameter = 25, height=40)
    towerTank.printSize()
//    aquarium6.volume = 70
//    aquarium6.printSize()
//    println("Volume: ${aquarium6.width* aquarium6.length*aquarium6.height / 1000} l" )
}

fun makeFish(){

    val shark = Shark()
    val pleco = Plecostmus()
    shark.eat()
    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
    pleco.eat()

}
