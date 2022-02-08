package com.example.ovolike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ovolike.databinding.AdapterPromoBinding
import com.example.ovolike.databinding.AdapterPurchaseBinding
import com.example.ovolike.databinding.AdapterRecomendationBinding
import com.example.ovolike.model.RecomendationModel

class RecomendationAdapter (var listItem : MutableList<RecomendationModel>, var listener: AdapterListener) : RecyclerView.Adapter<RecomendationAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterRecomendationBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterRecomendationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.ivRecomendation.setImageResource(item.image)
        holder.binding.tvTitleRecomendation.text = item.title
        holder.binding.tvSubtitleRecomendation.text = item.subTitle

        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface AdapterListener {
        fun onClick(RecomendationModel: RecomendationModel)
    }
}