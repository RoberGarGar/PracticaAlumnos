package com.example.practicaalumnos

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_student_detail.*

class StudentDetailActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor", "ResourceType")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        val detail = intent.getSerializableExtra("deta") as Students

        tv_namedetail.text = getString(R.string.name,detail.idName)
        tv_surnamedetail.text = getString(R.string.surname,detail.idSurname)
        tv_notedetail.text = getString(R.string.note,detail.idNote)
        tv_gradedetail.text = getString(R.string.grade,detail.idGrade)
        tv_agedetail.text = getString(R.string.age,detail.idAge.toString())

        changeBackground()

    }

    @SuppressLint("ResourceType")
    fun changeBackground(){

        val detail = intent.getSerializableExtra("deta") as Students
        val redST = getResources().getString(R.color.red)
        val greenST = getResources().getString(R.color.green)

        if(detail.idNote=="5" || detail.idNote=="6"|| detail.idNote=="7"|| detail.idNote=="8"|| detail.idNote=="9"|| detail.idNote=="10"){
            linear.setBackgroundColor(Color.parseColor(greenST))
        }else{
            linear.setBackgroundColor(Color.parseColor(redST))
        }
    }
}