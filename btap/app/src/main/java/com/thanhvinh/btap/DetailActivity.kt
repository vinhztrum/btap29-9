package com.thanhvinh.btap

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thanhvinh.btap.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnGoToMain.setOnClickListener {
            finish()
        }
        val bundle = intent.extras
        if (bundle != null) {
            val ten = bundle.getString("ten")
            val mssv = bundle.getString("mssv")

            // Dòng này bây giờ đã hoạt động vì tvHienThi đã có trong XML
            binding.tvHienThi.text = "Họ và tên: $ten \nMssv: $mssv"
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}