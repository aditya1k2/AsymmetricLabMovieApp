package coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
    runBlocking {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception Caught in Handler :-  ${throwable.message}")
        }
        supervisorScope {
            launch(exceptionHandler) {
                println("inside 1st launch")
                throw Exception("Exception Thrown")
            }
            launch {
                println("inside 2nd launch")
            }
        }
    }
}
