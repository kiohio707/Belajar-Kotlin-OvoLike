package com.example.ovolike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ovolike.databinding.AdapterIntroBinding
import com.example.ovolike.databinding.AdapterPromoBinding
import com.example.ovolike.databinding.AdapterPurchaseBinding
import com.example.ovolike.databinding.AdapterRecomendationBinding
import com.example.ovolike.model.IntroModel

class IntroAdapter (var listItem : MutableList<IntroModel>, var listener: AdapterListener) : RecyclerView.Adapter<IntroAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterIntroBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.tvIntro.text = item.title
        holder.binding.ivIntro.setImageResource(item.image)

        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface AdapterListener {
        fun onClick(IntroModel: IntroModel)
    }
}