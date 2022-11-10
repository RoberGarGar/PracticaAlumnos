package com.example.practicaalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = StudentAdapter(createStudents(),this)


    }

    private fun createStudents(): ArrayList<Students>{
        val list = ArrayList<Students>()
        list.add(Students(R.drawable.img1, "Armando","Escándalo", "3", "1ºA",10))
        list.add(Students(R.drawable.img2, "Mar","Lozano Ortiz", "9", "2ºB",11))
        list.add(Students(R.drawable.img3, "Clara","Gonzalez Iglesias", "6", "2ºB",11))
        list.add(Students(R.drawable.img4, "Iker","Gonzalez Lopez", "6", "2ºB",11))
        list.add(Students(R.drawable.img7, "Carmen","Caballero Vicente", "No presentado", "3ºA",12))
        list.add(Students(R.drawable.img8, "Valeria","Ortiz Santana", "10", "1ºA",10))
        list.add(Students(R.drawable.img5, "Rodrigo","Font Vicente", "No presentado", "3ºA",12))
        list.add(Students(R.drawable.img9, "Alejandra","Roca Cano", "1", "2ºB",11))
        list.add(Students(R.drawable.img6, "Arnau","Romero Gallardo", "2", "3ºA",12))

        return list
    }
}

