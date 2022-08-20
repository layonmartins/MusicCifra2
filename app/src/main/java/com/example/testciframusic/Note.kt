package com.example.testciframusic

import android.util.Log

//Enum class represent one music note
enum class Note(
    val note : String, //Dó, Ré, Mi...
    val cipher : String, //C, D, E...
    val code : Int? = null, //1 = C, 2 = D,
    var next : Note? = null,
    val previous : Note? = null
) {
    //TODO create another accident notes
    C("Dó", "C", 1),
    //C7("Dó seventh", "C7", 1),
    //C9("Dó ninth", "C9", 1),
    //Cm("Dó minor", "Cm", 1),
    //Cm7("Dó minor", "Cm7", 1),
    //Cm9("Dó minor", "Cm9", 1),
    //Cs("Dó sharp", "C#", 2),
    //Cs7("Dó sharp 7", "C#7", 2),
    //Cs9("Dó sharp 9", "C#9", 2),
    //Csm("Dó sharp minor", "C#m", 2),
    //Csm7("Dó sharp minor with seventh", "C#m7", 2),
    //Csm9("Dó sharp minor with seventh", "C#m9", 2),
    //are there another variations?

    //Db("Ré flat", "Db", 2),
    D("Ré", "D", 3),
    //Ds("Ré sharp", "D#", 4),

    //Eb("Mi flat", "Eb", 4),
    E("Mi", "E", 5),

    F("Fá", "F", 6),
    //Fs("Fá sharp", "F#", 7),

    //Gb("Sol flat", "Gb", 7),
    G("Sol", "G", 8),
    //Gs("Sol sharp", "G#", 9),

    //Ab("Lá flat", "Ab", 9),
    A("Lá", "A", 10),
    //As("Lá sharp", "A#", 11),

    //Bb("Si flat", "Bb", 11),
    B("Si", "B", 12);

    init {
        //setNexts()
    }

    //This function will setup all nexts 1/2 ton
    //check if can be done on init()
    //if works I can remove de val code
    //make with previous too
    fun setNexts() {
        Log.d("layon.f", "setEnumNexts")
        C.next = D
        D.next = E
        E.next = F
        F.next = G
        G.next = A
        A.next = B
        B.next = C
    }

    companion object {
        fun getNext(note : Note) : Note? {
            return when(note) {
                C -> D
                D -> E
                E -> F
                F -> G
                G -> A
                A -> B
                B -> C
                else -> null
            }
        }
    }

}