package com.example.lesson20.ui

interface LiveCycle<V>{
    fun bind(view:V)
    fun unbind()
}