package com.thanhvinh.btap

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thanhvinh.btap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Khởi tạo View Binding
        val binding = ActivityMainBinding.inflate(layoutInflater)

        // 2. Thiết lập giao diện MỘT LẦN DUY NHẤT
        setContentView(binding.root)

        // 3. Bắt sự kiện click nút Go To Detail
        binding.btnGoToDetail.setOnClickListener {
            // Khởi tạo Intent để chuyển màn hình
            val intent = Intent(this, DetailActivity::class.java)

            val bundle = Bundle()
            bundle.putString("ten", "Phạm Trần Thanh Vinh")
            bundle.putString("mssv", "241505312248")

            intent.putExtras(bundle)

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}