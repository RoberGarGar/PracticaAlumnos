package com.example.practicaalumnos

import java.io.Serializable

data class Students(

    var idStudents: Int,
    var idImage: Int,
    var idName: String,
    var idSurname: String,
    var idNote: Int,
    var idGrade: String,
    var idAge: Int


) : Serializable
