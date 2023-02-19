package com.architecture.model

data class Department(
    val department_id: Int,
    val name: String,
    val description: String
)

data class Category(
    val category_id: Int,
    val name: String,
    val description: String,
    val department_id: Int
)

data class Product(
    val product_id: Int,
    val name: String,
    val description: String,
    val price: String,
    val discounted_price: String,
    val thumbnail: String
)