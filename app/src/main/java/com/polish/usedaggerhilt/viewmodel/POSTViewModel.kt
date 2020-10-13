package com.polish.usedaggerhilt.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.polish.usedaggerhilt.data.localdatasource.blogdatabaserepo.BlogRepositoryImpl
import com.polish.usedaggerhilt.model.POSTItem
import com.polish.usedaggerhilt.repository.MainRepository
import com.polish.usedaggerhilt.util.DataState
import kotlinx.coroutines.*

class POSTViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    // I passed the blogDatabase object here
    private val blogDatabaseRepo:BlogRepositoryImpl,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
    /**
     *  create the coroutineScope
     */
    private val job = Job()
    private val viewModelScopeOne = CoroutineScope(job + Dispatchers.Main)

    /**
     *  use livedata to make the data observable
     */
    private val _myPost = MutableLiveData<DataState<List<POSTItem>>>()
    val myPost:LiveData<DataState<List<POSTItem>>>
    get() = _myPost

    /**
     * this is a liveData source from the database
     */

    val databaseSource = blogDatabaseRepo.posTitemDao.getPostsLiveData()


    init {
        getListOfPost()
    }


    /**
     * get the list of post to the viewmodel
     */
     fun getListOfPost(){
        viewModelScopeOne.launch {
            _myPost.value = mainRepository.getMyPost()
        }
    }

    override fun onCleared() {
        super.onCleared()
       job.cancel()
    }


}