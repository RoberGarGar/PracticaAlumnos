package com.example.practicaalumnos

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.service.controls.ControlsProviderService.TAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.MotionEffect.TAG
import androidx.constraintlayout.widget.ConstraintLayoutStates.TAG
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.students_list.view.*


class StudentAdapter (val listener:StudentAdapterListener) : ListAdapter<Students, StudentAdapter.ViewHolder>(StudentsAdapterDiffCallBack()) {

    interface StudentAdapterListener{
        fun onDeleteStudent(id:Int)
        fun onLongClickStudent(students: Students): Boolean
    }

    private class StudentsAdapterDiffCallBack : DiffUtil.ItemCallback<Students>() {

        override fun areItemsTheSame(
            oldStudent: Students,
            newStudent: Students
        ) = oldStudent.idStudents == newStudent.idStudents
        override fun areContentsTheSame(
            oldStudent: Students,
            newStudent: Students
        ): Boolean = true
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.students_list,
                parent,
                false
            ), parent.context
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private var view: View, private var context: Context) : RecyclerView.ViewHolder(view) {

        fun bind(student: Students) {

            view.iv_photo.setImageResource(student.idImage)
            view.tv_name.text = student.idName
            view.tv_surname.text = student.idSurname
            view.tv_note.text = student.idNote.toString()
            view.tv_grade.text = student.idGrade


            view.setOnClickListener{

                context.startActivity(Intent(context,StudentDetailActivity::class.java).putExtra("deta", student))

            }
            view.setOnLongClickListener{

                listener.onLongClickStudent(getItem(adapterPosition))

            }

            view.bt_delete.setOnClickListener{

                listener.onDeleteStudent(getItem(adapterPosition).idStudents)

            }

        }
    }

    fun getData():List<Students>{
        return currentList
    }

}