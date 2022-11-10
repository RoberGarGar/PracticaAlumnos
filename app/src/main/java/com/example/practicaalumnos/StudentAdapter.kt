package com.example.practicaalumnos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.students_list.view.*

class StudentAdapter(private var lista: ArrayList<Students>, private var context: Context) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.students_list,
                parent,
                false
            ), context
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    class ViewHolder(private var view: View, private var context: Context) : RecyclerView.ViewHolder(view) {
        fun bind(student: Students) {
            view.iv_photo.setImageResource(student.idImage)
            view.tv_name.text = student.idName
            view.tv_surname.text = student.idSurname
            view.tv_note.text = student.idNote
            view.tv_grade.text = student.idGrade

            view.setOnClickListener{

                context.startActivity(Intent(context,StudentDetailActivity::class.java).putExtra("deta", student))



            }

        }
    }

}