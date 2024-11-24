package com.example.b4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Tạo menu từ file XML
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Xử lý sự kiện khi chọn mục menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_search -> {
                Toast.makeText(this, "Chức năng Tìm kiếm đang được thực thi", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_settings -> {
                Toast.makeText(this, "Chức năng Cài đặt đang được thực thi", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_share -> {
                Toast.makeText(this, "Chức năng Chia sẻ đang được thực thi", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
