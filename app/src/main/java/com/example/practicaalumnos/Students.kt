package com.example.practicaalumnos

import java.io.Serializable

data class Students(

    var idImage: Int,
    var idName: String,
    var idSurname: String,
    var idNote: String,
    var idGrade: String,
    var idAge: Int

) : Serializable
