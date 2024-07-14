package com.example.myproject_kelvin.data

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproject_kelvin.databinding.ItemRowKarakterBinding

class ListKarakterAdapter(private val listKarakter: ArrayList<Karakter>) : RecyclerView.Adapter<ListKarakterAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowKarakterBinding) : RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowKarakterBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false) // Inflate layout
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listKarakter.size // Get item count

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listKarakter[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKarakter[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Karakter)
    }
}

private fun ImageView.setImageResource(photo: String) {
    Glide.with(this.context)
        .load(photo) // Load image from url
        .into(this) // Set image to ImageView
}
