package com.example.sandra.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.sandra.R
import com.example.sandra.Vaccine
import java.text.SimpleDateFormat
import java.time.*
import java.time.temporal.ChronoUnit
import java.util.*

class CalenderAdapter(c:Context, v:Vaccine, months:Long): RecyclerView.Adapter<CalenderAdapter.CalenderVH>() {

    val con = c
    val vaccine = v
    var monthsBetween = months
    class CalenderVH(view: View): RecyclerView.ViewHolder(view){
        val d = view.findViewById<CalendarView>(R.id.calendarView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderVH {
        val k = LayoutInflater.from(con).inflate(R.layout.calender_list, null)
        return CalenderVH(k)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CalenderVH, position: Int) {

        val df = SimpleDateFormat("yyyy.MM.dd")

        val polio1Day = df.parse(vaccine!!.polio1).time
        var dt = Date()
        val c = Calendar.getInstance(Locale.ENGLISH)
        c.time = Date(polio1Day)
        c.add(Calendar.MONTH, 1)
        dt = c.time


        val measlesDay = df.parse(vaccine.measles).time
        var mDt = Date()
        c.time = Date(measlesDay)
        c.add(Calendar.MONTH, 1)
        mDt = c.time


        monthsBetween = ChronoUnit.MONTHS.between(
                YearMonth.from(LocalDate.parse(vaccine.polio1)),
        YearMonth.from(LocalDate.parse(vaccine.measles))
        )

        val polio2Day = df.parse(vaccine.polio2).time
        val polio3Day = df.parse(vaccine.polio3).time

        for (i in 0..monthsBetween){
            holder.d


            holder.d.setDate(polio1Day)
            holder.d.setDate(polio2Day)
            holder.d.setDate(polio3Day)
            holder.d.setDate(measlesDay)

        }

    }

    override fun getItemCount(): Int {
        return monthsBetween.toInt()
    }
}