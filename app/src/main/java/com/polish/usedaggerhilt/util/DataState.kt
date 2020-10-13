package com.polish.usedaggerhilt.util
/*8
    this is a data wrapper
 */
sealed class DataState<out R> {

    data class Success<out T>(val data:T):DataState<T>()
    data class Error(val exception:Exception):DataState<Nothing>()
    object loading: DataState<Nothing>()

}