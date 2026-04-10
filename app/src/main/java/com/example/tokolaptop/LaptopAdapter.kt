package com.example.tokolaptop

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaptopAdapter(private val listLaptop: ArrayList<Laptop>) : RecyclerView.Adapter<LaptopAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgItemPhoto)
        val tvName: TextView = itemView.findViewById(R.id.tvItemName)
        val tvSpecs: TextView = itemView.findViewById(R.id.tvItemSpecs)
        val tvPrice: TextView = itemView.findViewById(R.id.tvItemPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_laptop, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, specs, price, description, image) = listLaptop[position]
        holder.imgPhoto.setImageResource(image)
        holder.tvName.text = name
        holder.tvSpecs.text = specs
        holder.tvPrice.text = price

        // FITUR EXPLICIT INTENT (Pindah Halaman Bawa Data)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("EXTRA_LAPTOP", listLaptop[position])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listLaptop.size
}