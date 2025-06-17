package designPatters.singleton

class Singleton private constructor(){

    init {
        println("Singleton Instance Created ${this.hashCode()}")
    }

    companion object {

        @Volatile
        private var instance : Singleton?= null

        fun getInstance() : Singleton {
            if(instance == null){
                synchronized(this){
                    if(instance == null){
                        instance = Singleton()
                    }

                }
            }
            return instance!!
        }
    }

    fun showMessage() {
        println("Hello from Singleton: ${this.hashCode()}")
    }
}