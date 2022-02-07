package com.example.ovolike

import android.os.Bundle
import android.widget.Toast
import com.example.ovolike.adapter.PurchaseAdapter
import com.example.ovolike.databinding.ActivityMainBinding
import com.example.ovolike.model.PurchaseModel

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

        //Set Adapter ke Recycler View
        binding.recViewPurchase.adapter = purchaseAdapter
    }

    val purchaseAdapter by lazy {
        val item = mutableListOf<PurchaseModel>(
            PurchaseModel(1, "PLN", R.drawable.ic_electric),
            PurchaseModel(2, "Pulsa", R.drawable.ic_phone),
            PurchaseModel(3, "Voucher Game", R.drawable.ic_game),
            PurchaseModel(4, "Investasi", R.drawable.ic_invest),
            PurchaseModel(5, "BPJS", R.drawable.ic_bpjs),
            PurchaseModel(6, "Internet & TV Kabel", R.drawable.ic_tv),
            PurchaseModel(7, "Proteksi", R.drawable.ic_proteksi),
            PurchaseModel(8, "Lainnya", R.drawable.ic_other),
        )
        PurchaseAdapter(item, object: PurchaseAdapter.AdapterListener{
            override fun onClick(purchaseModel: PurchaseModel) {
                Toast.makeText(applicationContext, purchaseModel.text, Toast.LENGTH_SHORT).show()
            }
        })
    }
}