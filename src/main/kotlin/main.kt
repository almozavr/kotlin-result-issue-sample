import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val flow1 = flowOf(Result.success(1))
    val result = flow1.flatMapMerge {
        it.fold(
            { flowOf(Result.success("success")) },
            { flowOf(Result.success("fail")) }
        )
    }.single()
    result
        .onSuccess { println(it) }
        .onFailure { println(it) }
}