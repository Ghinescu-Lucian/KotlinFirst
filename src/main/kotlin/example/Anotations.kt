package example

//import kotlin.reflecte
import kotlin.reflect.full.*
class Annotations {
}

@ImAPlant class Plant{

    @get: OnGet
    val isGrowing: Boolean = true

    @set: OnSet
    var needsFood: Boolean = false

    fun trim() {}
    fun fertilize() {}
}
fun testAnnotations() {
    val classObj = Plant:: class
//    for(m in classObj.declaredMemberFunctions){
//        println(m.name)
//    }

//    for(m in classObj.annotations){
//        println(m.annotationClass.simpleName)
//    }
    val plantObject = Plant:: class
    val myAnnotationObject = plantObject.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}

annotation class ImAPlant
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet


fun labels(){
    outerloop@ for ( i in 1..100){
        print("$i ")
        for(j in 1..100){
            if(i>10) break@outerloop
        }
    }
}


fun main() {
    testAnnotations()
    labels()
}