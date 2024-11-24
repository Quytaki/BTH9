package com.example.b2

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tìm Button
        val btnDeleteAll: Button = findViewById(R.id.btnDeleteAll)

        // Gắn sự kiện nhấn nút
        btnDeleteAll.setOnClickListener {
            // Tạo AlertDialog
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Cảnh báo")
                .setMessage("Bạn có chắc chắn muốn xóa toàn bộ dữ liệu không?")
                .setPositiveButton("Xác nhận") { dialog, _ ->
                    // Hiển thị Toast
                    Toast.makeText(this, "Đã xóa dữ liệu", Toast.LENGTH_SHORT).show()
                    dialog.dismiss() // Đóng AlertDialog
                }
                .setNegativeButton("Hủy") { dialog, _ ->
                    dialog.dismiss() // Đóng AlertDialog
                }
                .create()

            // Hiển thị AlertDialog
            alertDialog.show()
        }
    }
}
