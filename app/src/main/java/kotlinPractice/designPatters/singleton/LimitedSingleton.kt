package designPatters.singleton

public class LimitedSingleton{

    private val inUse : Boolean = false

    init {
        println("Single Instance Created ${this.hashCode()}")
    }
    companion object  {
        private var instances = mutableListOf<LimitedSingleton>()
    }
}

fun main(){
    listOf("2",2,4)
    mutableListOf("adssadf")
}