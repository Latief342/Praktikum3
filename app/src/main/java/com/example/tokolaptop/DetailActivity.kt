package com.example.tokolaptop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: ImageView = findViewById(R.id.imgDetailPhoto)
        val tvName: TextView = findViewById(R.id.tvDetailName)
        val tvSpecs: TextView = findViewById(R.id.tvDetailSpecs)
        val tvPrice: TextView = findViewById(R.id.tvDetailPrice)
        val tvDescription: TextView = findViewById(R.id.tvDetailDescription)
        val btnShare: Button = findViewById(R.id.btnShare)

        // MENERIMA DATA DARI INTENT
        val laptop = intent.getSerializableExtra("EXTRA_LAPTOP") as Laptop?

        if (laptop != null) {
            imgPhoto.setImageResource(laptop.imageResId)
            tvName.text = laptop.name
            tvSpecs.text = laptop.specs
            tvPrice.text = laptop.price
            tvDescription.text = laptop.description

            // FITUR IMPLICIT INTENT (Share Data)
            btnShare.setOnClickListener {
                val shareText = "Cek laptop idaman ini!\n\nNama: ${laptop.name}\nSpek: ${laptop.specs}\nHarga: ${laptop.price}\n\nKeterangan: ${laptop.description}"
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, shareText)
                }
                startActivity(Intent.createChooser(shareIntent, "Bagikan Informasi Laptop via:"))
            }
        }
    }
}