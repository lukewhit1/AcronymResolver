package com.example.acronymresolver

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acronymresolver.databinding.CardItemBinding
import com.example.acronymresolver.model.DisplayData

class ItemDisplayAdapter(var data :  List<DisplayData>) : RecyclerView.Adapter<ItemDisplayAdapter.ItemDisplayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisplayViewHolder {
        val binding =  CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisplayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDisplayViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun changeData(newData : List<DisplayData>){
        data = newData
        notifyDataSetChanged()
    }

    inner class ItemDisplayViewHolder(private val binding : CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvAcronym.text = data[position].acronyms
            binding.tvMeaning.text = data[position].longForms.joinToString()
        }
    }
}
