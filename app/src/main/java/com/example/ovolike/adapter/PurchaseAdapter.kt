package com.example.ovolike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ovolike.databinding.AdapterPurchaseBinding
import com.example.ovolike.model.PurchaseModel

class PurchaseAdapter ( var listItem : MutableList<PurchaseModel>, var listener: AdapterListener) : RecyclerView.Adapter<PurchaseAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterPurchaseBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterPurchaseBinding.inflate(LayoutInflater.from(parent.context), null, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.tvIconAdapter.text = item.text
        holder.binding.ivIconAdapter.setImageResource(item.icon)

        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface AdapterListener {
        fun onClick(purchaseModel: PurchaseModel)
    }
}