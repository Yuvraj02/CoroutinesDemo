package com.reckonco.coroutinesdemo

import kotlinx.coroutines.*

class UserDataManager2 {

    lateinit var deferred:Deferred<Int>

    suspend fun getTotalUserCount() : Int{
        var count = 0
        coroutineScope {
            launch {
                delay(3000)
                count = 50
            }

            deferred = async {
                delay(500)
                return@async 70
            }
        }
        return count+deferred.await()
    }
}