package com.reckonco.coroutinesdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager1 {

    suspend fun getTotalUserCount() : Int{
        var count = 0
        CoroutineScope(IO).launch {
            delay(1000)
            count = 50
        }

        val def = CoroutineScope(IO).async{
            delay(3000)
            return@async 70
        }

        return count + def.await()
    }
}