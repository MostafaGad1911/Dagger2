package com.apiTask.AppsSquare.Model

import dagger.Module
import javax.inject.Inject

data class DataModel @Inject constructor(
    val count: Int,
    val `data`: ArrayList<Product>,
    val message: String,
    val status: Boolean
)


class Product @Inject constructor(){
    var id: Int = 0
    var image: String? = null
    var name: String? = null
    var price: Int? = null
    var quantity: Int? = null

}