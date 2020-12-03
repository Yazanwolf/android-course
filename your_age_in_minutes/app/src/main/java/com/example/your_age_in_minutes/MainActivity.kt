package com.example.your_age_in_minutes

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDatePicker.setOnClickListener { view -> showDatePicker(view) }
    }

    /*
        this is not a beautiful code and therefor you need to read the description
        Date.time gets you the time in milliseconds since 1970 till the chosen date
     */
    private fun showDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val currentYear = myCalendar.get(Calendar.YEAR)
        val currentMonth = myCalendar.get(Calendar.MONTH)
        val currentDay = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            view.context,
            { view, year, month, dayOfMonth ->
                val pickedDate = "$year/${month + 1}/$dayOfMonth"
                selectedDate.text = pickedDate
                val simplDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                var chosenDate = simplDateFormat.parse(pickedDate)

                val chosenDateInMinutes = chosenDate!!.time / 60000
                val currentDateInMinutes = simplDateFormat
                    .parse(simplDateFormat.format(System.currentTimeMillis()))!!.time / 60000
                ageInMinutes.text = "${currentDateInMinutes - chosenDateInMinutes}"
            },
            currentYear,
            currentMonth,
            currentDay
        ).show()
    }
}