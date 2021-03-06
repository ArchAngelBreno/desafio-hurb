package com.desafiohurb.core.base

abstract class BaseRepository {


    protected suspend fun <T> networkBoundResource(
        saveCallResult: suspend (T) -> Unit,
        shouldFetch: (T) -> Boolean,
        makeApiCall: suspend () -> T,
        loadFromDb: suspend () -> T
    ): T? {
        return if (shouldFetch(loadFromDb())) {
            try {
                makeApiCall.invoke()?.let { result ->
                    saveCallResult(result)
                    result
                }
            } catch (t: Throwable) {
                throw t
            }
        } else {
            loadFromDb.invoke()
        }
    }


    protected fun <Entity,Domain> Entity?.transform(transform: (Entity) -> Domain): Domain? {
        return this?.let { transform.invoke(it) }
    }

}