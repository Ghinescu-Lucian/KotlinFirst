package Exercices

import kotlin.math.sqrt

class codeWARS {
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    val sorted = ages .sortedByDescending{it}
    var list = mutableListOf<Int>(sorted[0],sorted[1])

    val list1 = list.sortedByDescending{it}
    return list1
}

fun solution(number: Int): Int {
    var s =0
    if(number < 0)
        return 0
    else{

        for(i  in 1..number){
            if(i %3 ==0 || i %5 ==0)
                s= s+i
        }
    }
    return s
}
// SAU
fun solution1(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()

fun accum(s:String):String {
    // your code
    var n =0
    var solution=""
    for(c in s){
        if(c in 'a'..'z' || c in 'A'..'Z'){
            var a = c.toUpperCase()
            var aju=""
            var n2 =n
            while(n2 != 0){
                n2--
                aju= aju+c.toLowerCase()
            }
            aju=a+aju+"-"
            solution= solution+aju
            n++
        }
    }
    return solution.dropLast(1)
}
// SAU
fun accum1(s: String) = s.chunked(1)
    .mapIndexed { index, char -> "${char.uppercase()}${char.lowercase().repeat(index)}" }
    .joinToString("-")

fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int{
    var prod = age1*age1 + age1*age1 + age2*age2 + age3*age3 + age4*age4 + age5*age5 + age6*age6 +age7*age7 + age8*age8
    var sq = sqrt(prod.toDouble())
    sq = sq/2
    var predict = sq.toInt()
    return predict
}

/*
SAU

import kotlin.math.sqrt

fun predictAge(vararg ages: Int): Int =
    ages.map { it * it }
        .sum()
        .toDouble()
        .let { sqrt(it) }
        .div(2)
        .toInt()

 */
 // timed out
fun sumParts_1(ls: IntArray): IntArray {
    // your code
    var solution = mutableListOf<Int>()
    var index = 0
    while(index < ls.size){

        var s = ls.sum()
        println("Ceva $s")
        solution.add(s)
        ls[index] = 0
        index++
    }
    solution.add(0)
    return solution.toIntArray()

}

fun sumParts(ls: IntArray): IntArray {
//    // your code
//    var solution = mutableListOf<Int>()
//    if(ls.size == 0) return solution.toIntArray()
//    solution.add(0)
//    solution.add(ls[0])
//
//    var index = 1
//
//    while(index < ls.size){
//
//        var s = solution[index] + ls.get(index)
//        solution.add(s)
//      //  println("S $index: ${solution[index-1]}  ${ls.get(index)}")
//        index++
//
//    }
//        // var s = solution.reverse()
//    var sol = solution.reversed()
////    println("Sum: ")
////    for(i in sol){
////        println(i)
////    }
//    return sol.toIntArray()

    var a = ls
    val solution = IntArray(ls.size + 1)
    var index = 0;
    // -ls[0]
    while (index < a.size) {
        if (index == 0)
            solution[index] = a.sum()
        else solution[index] = solution[index - 1] - a[index-1]
        //  println(a.joinToString())
        //  a= a-a[0]
        index++


    }
    return solution.apply{
        println(joinToString())
    }
}
fun main()
{
//    println(accum("aBc"))
    val array =IntArray(3)
    array[0] = 1
    array[1] = 2
    array[2] = 3
//    var
   // sumParts(array)
    print(sumParts(array).size)
}