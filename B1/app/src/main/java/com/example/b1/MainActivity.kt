package com.example.b1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnChooseDateTime: Button
    private lateinit var tvSelectedDateTime: TextView

    private var year = 0
    private var month = 0
    private var day = 0
    private var hour = 0
    private var minute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo các thành phần UI
        btnChooseDateTime = findViewById(R.id.btnChooseDateTime)
        tvSelectedDateTime = findViewById(R.id.tvSelectedDateTime)

        // Lấy ngày giờ hiện tại
        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        hour = calendar.get(Calendar.HOUR_OF_DAY)
        minute = calendar.get(Calendar.MINUTE)

        // Set sự kiện cho nút "Chọn ngày giờ"
        btnChooseDateTime.setOnClickListener {
            // Mở DatePickerDialog để chọn ngày
            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                // Lưu lại ngày đã chọn
                year = selectedYear
                month = selectedMonth
                day = selectedDay

                // Mở TimePickerDialog để chọn giờ
                val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                    // Lưu lại giờ đã chọn
                    hour = selectedHour
                    minute = selectedMinute

                    // Hiển thị ngày giờ đã chọn trong TextView
                    val selectedDateTime = String.format("%02d/%02d/%d - %02d:%02d",
                        day, month + 1, year, hour, minute)
                    tvSelectedDateTime.text = "Ngày giờ đã chọn: $selectedDateTime"
                }, hour, minute, true)
                timePickerDialog.show()
            }, year, month, day)
            datePickerDialog.show()
        }
    }
}
