package kotlinPractice.designPatters.singleton

import designPatters.singleton.Singleton

fun main(){
    val singletonA = Singleton.getInstance()
    val singletonB = Singleton.getInstance()

    singletonA.showMessage()
    singletonB.showMessage()

    println("Check instance : ${singletonA == singletonB}")
}