package com.example.ovolike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ovolike.databinding.AdapterInterestBinding
import com.example.ovolike.databinding.AdapterPromoBinding
import com.example.ovolike.databinding.AdapterPurchaseBinding
import com.example.ovolike.databinding.AdapterRecomendationBinding
import com.example.ovolike.model.InterestModel

class InterestAdapter (var listItem : MutableList<InterestModel>, var listener: AdapterListener) : RecyclerView.Adapter<InterestAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterInterestBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterInterestBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.ivInterest.setImageResource(item.image)
        holder.binding.tvInterest.text = item.title
        holder.binding.tvDescInterest.text = item.description
        holder.binding.tvLinkInterest.text = item.linkTitle
        
        
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface AdapterListener {
        fun onClick(InterestModel: InterestModel)
    }
}