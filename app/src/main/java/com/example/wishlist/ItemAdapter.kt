package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items : List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName : TextView
        val itemPrice : TextView
        val itemUrl : TextView

        init {
            itemName = itemView.findViewById(R.id.wishlistItemName)
            itemPrice = itemView.findViewById(R.id.wishlistItemPrice)
            itemUrl = itemView.findViewById(R.id.wishlistItemURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflator = LayoutInflater.from(context)

        val contactView = inflator.inflate(R.layout.wishlist_item,parent,false)

        return  ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)

        holder.itemName.text = item.name
        holder.itemPrice.text = item.price.toString()
        holder.itemUrl.text = item.url
    }

    override fun getItemCount(): Int {
        return  items.size
    }
}