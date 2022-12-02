package com.example.practicaalumnos


import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import kotlin.math.log


class MiniDetailDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return super.onCreateDialog(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val dialogView = inflater.inflate(R.layout.dialog_mini_detail, container, false)
        if (getArguments() != null) {

            val mArgs = arguments
            val myName= mArgs?.getString("nameData")
            val mySurname= mArgs?.getString("surnameData")
            val myNote= mArgs?.getString("noteData")
            val myAge= mArgs?.getString("ageData")

            dialogView.findViewById<TextView>(R.id.tv_dialogName).text= myName
            dialogView.findViewById<TextView>(R.id.tv_dialogSurname).text= mySurname
            dialogView.findViewById<TextView>(R.id.tv_dialogNote).text= myNote
            dialogView.findViewById<TextView>(R.id.tv_dialogAge).text= myAge

        }
        return dialogView
    }
}
