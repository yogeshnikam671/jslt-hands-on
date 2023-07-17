package model

data class Person(
    val name: String,
    val age: Int,
    val hobbies: List<String>,
    val address: Address,
)

data class Address(
    val city: String,
    val pinCode: Int,
)
