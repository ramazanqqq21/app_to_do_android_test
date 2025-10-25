package com.ramazan.app.model

interface MyCustomCallback<T> {
    fun onSuccess(model:T){}
    fun onSuccess(listModel:List<T>){}
    fun onFailure(exception:String){}
    fun notify(msg:String){}
}