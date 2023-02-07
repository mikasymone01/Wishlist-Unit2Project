package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var  items: List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.itemName)
        val priceInput = findViewById<EditText>(R.id.itemPrice)
        val urlInput = findViewById<EditText>(R.id.itemURL)

        val itemRV = findViewById<RecyclerView>(R.id.ItemRV)

        items = ItemFetcher.initialize()
        val adapter = ItemAdapter(items)
        itemRV.adapter = adapter
        itemRV.layoutManager = LinearLayoutManager(this)
        val submitButton = findViewById<Button>(R.id.submitButton)


        submitButton.setOnClickListener{
            if(nameInput.text.isEmpty() || priceInput.text.isEmpty() || urlInput.text.isEmpty()){
                Toast.makeText(this,"One or more entries empty",Toast.LENGTH_LONG).show()
            }else{
            val newItem = Item(nameInput.text.toString(), priceInput.text.toString().toFloat(),urlInput.text.toString())
            (items as MutableList<Item>).add(newItem)
            adapter.notifyDataSetChanged()
        }
        }
    }
}