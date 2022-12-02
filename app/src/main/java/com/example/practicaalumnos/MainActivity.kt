package com.example.practicaalumnos

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapterListener=object : StudentAdapter.StudentAdapterListener {
        @RequiresApi(Build.VERSION_CODES.N)

        override fun onDeleteStudent(id: Int) {
            val data = adapter.getData().toMutableList()
            data.removeIf { it.idStudents == id }
            adapter.submitList(data.toList())
        }

        override fun onLongClickStudent(students: Students): Boolean {

            val fm = supportFragmentManager
            val dialogFragment = MiniDetailDialog()
            var args: Bundle? = Bundle()
            args?.putString("nameData", students.idName)
            args?.putString("surnameData", students.idSurname)
            args?.putString("noteData", students.idNote.toString())
            args?.putString("ageData", students.idAge.toString())

            dialogFragment.setArguments(args)
            dialogFragment.show(fm, "MiniDetailDialog")

            Log.i(args.toString(),"prueba")
            return true
        }

    }

    private val list:ArrayList<Students> by lazy { createStudents() }
    val adapter:StudentAdapter by lazy {StudentAdapter(adapterListener)}

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.adapter = adapter
        adapter.submitList(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.findapprovedID -> {
                val menuList = findApproved(list)
                adapter.submitList(menuList)
                true
            }
            R.id.findsuspenseID -> {
                val menuList = findSuspense(list)
                adapter.submitList(menuList)
                true
            }
            R.id.findgradeID1A -> {
                val menuList = findGrade1A(list)
                adapter.submitList(menuList)
                true
            }
            R.id.findgradeID2B -> {
                val menuList = findGrade2B(list)
                adapter.submitList(menuList)
                true
            }
            R.id.findgradeID3A -> {
                val menuList = findGrade3A(list)
                adapter.submitList(menuList)
                true
            }
            R.id.findnoteID -> {
                val menuList = orderNote(list)
                adapter.submitList(menuList)
                true
            }
            R.id.findnameID -> {
                val menuList = orderName(list)
                adapter.submitList(menuList)
                true
            }
            R.id.calculateAverage-> {
                calculateaverage(list)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun findApproved(list:ArrayList<Students>) = list.filter { e -> e.idNote in 5..10}

    fun findSuspense(list:ArrayList<Students>) = list.filter { e -> e.idNote in 0..4}

    fun findGrade1A(list:ArrayList<Students>) = list.filter { e -> e.idGrade.equals("1ºA")}

    fun findGrade2B(list:ArrayList<Students>) = list.filter { e -> e.idGrade.equals("2ºB")}

    fun findGrade3A(list:ArrayList<Students>) = list.filter { e -> e.idGrade.equals("3ºA")}

    fun orderNote(list:ArrayList<Students>) = list.sortedByDescending { e -> e.idNote}

    fun orderName(list:ArrayList<Students>) = list.sortedBy { e -> e.idName}

    fun calculateaverage(list:ArrayList<Students>) {

        var suma = 0f
        list.forEach{
        suma+=it.idNote
        }
        val result =  suma/list.size

        Snackbar.make(this.recycler,result.toString(),Snackbar.LENGTH_LONG).show()
    }

    private fun createStudents(): ArrayList<Students>{
        val list = ArrayList<Students>()
        list.add(Students(1,R.drawable.img1, "Armando","Escándalo", 3, "1ºA",10))
        list.add(Students(2,R.drawable.img2, "Mar","Lozano Ortiz", 9, "2ºB",11))
        list.add(Students(3,R.drawable.img3, "Clara","Gonzalez Iglesias", 6, "2ºB",11))
        list.add(Students(4,R.drawable.img4, "Iker","Gonzalez Lopez", 6, "2ºB",11))
        list.add(Students(5,R.drawable.img7, "Carmen","Caballero Vicente", 0, "3ºA",12))
        list.add(Students(6,R.drawable.img8, "Valeria","Ortiz Santana", 10, "1ºA",10))
        list.add(Students(7,R.drawable.img5, "Rodrigo","Font Vicente", 0, "3ºA",12))
        list.add(Students(8,R.drawable.img9, "Alejandra","Roca Cano", 1, "2ºB",11))
        list.add(Students(9,R.drawable.img6, "Arnau","Romero Gallardo", 2, "3ºA",12))

        return list
    }

}
