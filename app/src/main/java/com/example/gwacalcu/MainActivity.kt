package com.example.gwacalcu

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    var gradeEntries:ArrayList<Int> = ArrayList();

    private fun handleCompute(): Int {
        return (gradeEntries.sum() / gradeEntries.size).toFloat().roundToInt()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun handleEntries(): Unit? {
        //Handle blank gradeField
        val gradeInputField = findViewById<EditText>(R.id.gradeInput)
        if (gradeInputField.text.isEmpty()){
            Toast.makeText(this,"Please Input Grades",Toast.LENGTH_LONG).show()
            return null
        }

        //Handle blank nameField
        val subjectNameField = findViewById<EditText>(R.id.subjectInput)
        if (subjectNameField.text.isEmpty()){
            subjectNameField.setText( "Unknown Subject")
        }


        val subjectName = subjectNameField.text.toString()
        val gradeValue = Integer.parseInt(gradeInputField.text.toString())
        gradeEntries.add(gradeValue)
        val entry = TextView(this)
        val text = "$subjectName $gradeValue"
        entry.text = text
        val layoutOutput = findViewById<LinearLayout>(R.id.entriesLayout)
        layoutOutput.addView(entry)
        subjectNameField.setText("")
        gradeInputField.setText("")
        val displayAns = findViewById<TextView>(R.id.displayResult)
        entry.outlineSpotShadowColor = Color.BLACK
        displayAns.text = "General Average: "+handleCompute().toString()
        return null
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addBtn = findViewById<Button>(R.id.addBtn)
        addBtn.setOnClickListener { handleEntries() }
    }


}