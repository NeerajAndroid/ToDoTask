package com.example.practicekotlin

fun main() {

    val (x,y,z) = Triple(1,"testTriple",2.0)
    println("Hello World")
    var test = Person().let {
        it.age = 50
        it.name = "Sahu"
        println("Person name : ${it.name} age : ${it.age}")
    }
    println(test)

    var test2 =Person().apply { name = "TestApply"
    age = 31
        println("Person name : ${name} age : ${age}")
    }
    println(test2)
    var person : Person? = null
    person?.let {  it.age = 50
        it.name = "Sahu"
        println("Person name : ${it.name} age : ${it.age}") }
}

class Person() {
    var name: String = "Neeraj"
    var age: Int = 30
}
