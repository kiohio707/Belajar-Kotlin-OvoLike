package com.example.ovolike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ovolike.databinding.AdapterPromoBinding
import com.example.ovolike.databinding.AdapterPurchaseBinding
import com.example.ovolike.model.PromoModel

class PromoAdapter (var listItem : MutableList<PromoModel>, var listener: AdapterListener) : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterPromoBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterPromoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.ivPromo.setImageResource(item.image)

        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface AdapterListener {
        fun onClick(promoModel: PromoModel)
    }
}