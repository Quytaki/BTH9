package com.example.b3

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tìm các View
        val tvName: TextView = findViewById(R.id.tvName)
        val btnShowDialog: Button = findViewById(R.id.btnShowDialog)

        // Gắn sự kiện cho nút "Nhập tên của bạn"
        btnShowDialog.setOnClickListener {
            // Inflate layout của Custom AlertDialog
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null)

            // Tạo AlertDialog
            val alertDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create()

            // Tìm EditText từ dialog
            val etName = dialogView.findViewById<EditText>(R.id.etName)

            // Set sự kiện cho nút trong dialog
            dialogView.findViewById<Button>(R.id.btnSave).setOnClickListener {
                val enteredName = etName.text.toString()
                if (enteredName.isNotEmpty()) {
                    tvName.text = enteredName // Hiển thị tên trên TextView
                    Toast.makeText(this, "Tên đã được lưu!", Toast.LENGTH_SHORT).show()
                    alertDialog.dismiss()
                } else {
                    Toast.makeText(this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show()
                }
            }

            dialogView.findViewById<Button>(R.id.btnCancel).setOnClickListener {
                alertDialog.dismiss() // Đóng dialog khi nhấn "Hủy"
            }

            // Hiển thị AlertDialog
            alertDialog.show()
        }
    }
}
