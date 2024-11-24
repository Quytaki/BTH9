package com.example.b5

import android.app.AlertDialog
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val nameList = mutableListOf("Nam", "Huy", "Lan", "Mai", "Linh","Vinh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
        listView.adapter = adapter

        // Đăng ký ContextMenu cho ListView
        registerForContextMenu(listView)
    }

    // Tạo ContextMenu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    // Xử lý sự kiện khi chọn mục trong ContextMenu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position = info.position

        return when (item.itemId) {
            R.id.edit -> {
                showEditDialog(position)
                true
            }
            R.id.delete -> {
                nameList.removeAt(position)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Đã xóa thành công", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // Hiển thị AlertDialog để sửa tên
    private fun showEditDialog(position: Int) {
        val editText = EditText(this).apply {
            setText(nameList[position])
        }

        AlertDialog.Builder(this)
            .setTitle("Chỉnh sửa tên")
            .setView(editText)
            .setPositiveButton("Lưu") { _, _ ->
                val newName = editText.text.toString()
                if (newName.isNotBlank()) {
                    nameList[position] = newName
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "Đã cập nhật tên", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Tên không được để trống", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Hủy", null)
            .show()
    }
}
