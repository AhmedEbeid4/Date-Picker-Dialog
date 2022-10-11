package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.time.Year
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            btnAction()
            binding.resultFather.visibility=View.VISIBLE
            binding.txto.visibility=View.GONE
        }
    }
    private fun btnAction(){
        val calender=Calendar.getInstance()
        val year=calender.get(1)
        val month=calender.get(2)
        val day=calender.get(5)

        DatePickerDialog(this, { view,year,month,day ->
            binding.dateText.text="$day/${month+1}/$year"
            binding.minutesText.text="${getMinutes(day, month, year)}"
        },year,month,day).show()
    }
    private fun getMinutes(day:Int,month:Int,year:Int):Int{
        val moshtarak:Int= 24 * 60
        return (day * moshtarak) + (month * 30 * moshtarak) + (year * 12 * 30 * moshtarak)
    }
}