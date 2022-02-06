package com.example.ovolike

import android.os.Bundle
import android.widget.Toast
import com.example.ovolike.databinding.ActivityMainBinding

class MainActivity : HelperActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.tvOvoCashMain.text = "500.000"

        binding.toolbarMain.inflateMenu(R.menu.menu_notification_main)

        val menu = binding.toolbarMain.menu
        menu.findItem(R.id.menu_notification).setOnMenuItemClickListener {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
            true
        }

        binding.ivTopupMain.setOnClickListener {
            Toast.makeText(this, "Top Up", Toast.LENGTH_SHORT).show()
        }

        binding.ivTransferMain.setOnClickListener {
            Toast.makeText(this, "Transfer", Toast.LENGTH_SHORT).show()
        }

        binding.ivHistoryMain.setOnClickListener {
            Toast.makeText(this, "Riwayat", Toast.LENGTH_SHORT).show()
        }


    }
}