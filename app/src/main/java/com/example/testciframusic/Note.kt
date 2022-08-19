package com.example.testciframusic

//Enum class represent one music note
enum class Note(
    val note : String, //Dó, Ré, Mi...
    val cipher : String, //C, D, E...
    val code : Int, //1 = C, 2 = D
) {
    C("Dó", "C", 1),
    D("Ré", "D", 2),
    E("Mi", "E", 3),
    F("Fá", "F", 4),
    G("Sol", "G", 5),
    A("Lá", "A", 6),
    B("Si", "B", 7),
}