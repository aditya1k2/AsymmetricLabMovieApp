package networkUtils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

object NetworkUtils {
    fun <T> toApiResult(call: suspend () -> Response<T>): Flow<ApiResult<T>> {
        return flow {
            try {
                val c = call()
                if (c.isSuccessful) {
                    emit(ApiResult.Success(c.body()))
                } else {
                    emit(ApiResult.Error(c.errorBody().toString()))
                }
            } catch (e: Exception) {
                emit(ApiResult.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}