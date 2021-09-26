package com.reckonco.coroutinesdemo

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class MainActivityViewModel : ViewModel() {

   // private val userDataManager1 = UserDataManager1()


    var num1 = MutableLiveData(0)

    var count = MutableLiveData(0)


    fun incrementVal(){
       count.value = count.value?.plus(1)
    }

     fun coroutine1(){
        CoroutineScope(Dispatchers.IO).launch {
             suspendedCoroutine1()
        }
    }

    fun coroutine2(){
        CoroutineScope(Dispatchers.Main).launch {
           num1.value = UserDataManager2().getTotalUserCount()
            Log.d("MainActivity","${num1.value}")
        }
    }

    suspend fun suspendedCoroutine1(){
        withContext(Dispatchers.Main){
            for (i in 1..20000){
                incrementVal()
                     Log.d("MainActivity","This loop has looped  $i times in ${Thread.currentThread().name}")
            }
        }
    }

//    fun loop(){
//
//    }
}