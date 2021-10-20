package com.example.testingflowlifecycleawareness.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _data: MutableLiveData<String> = MutableLiveData()
    val data: LiveData<String> get() = _data

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repository.sendData().collect {
                _data.postValue(it.toString())
            }
        }
    }
}
