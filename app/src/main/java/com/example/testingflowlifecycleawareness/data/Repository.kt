package com.example.testingflowlifecycleawareness.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository {

    fun sendData(): Flow<Int> = flow {
        val num = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        num.forEach {
            delay(2000)
            emit(it)
        }
    }
}
