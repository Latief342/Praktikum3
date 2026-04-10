package com.example.tokolaptop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLaptops: RecyclerView
    private val list = ArrayList<Laptop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLaptops = findViewById(R.id.rvLaptops)
        rvLaptops.setHasFixedSize(true)

        list.addAll(getListLaptops())
        showRecyclerList()
    }

    private fun getListLaptops(): ArrayList<Laptop> {
        val dataName = arrayOf(
            "Asus ROG Strix", "Acer Predator Helios", "Lenovo Legion 5", "HP Omen 16",
            "MSI Katana GF66", "MacBook Pro M2", "Dell XPS 15", "Razer Blade 15",
            "Asus Zenbook 14", "Lenovo Thinkpad X1"
        )
        val dataSpecs = arrayOf(
            "Core i9, RTX 4070, 16GB RAM", "Core i7, RTX 3070, 32GB RAM", "Ryzen 7, RTX 4070, 16GB RAM", "Ryzen 9, RTX 3070, 16GB RAM",
            "Core i7, RTX 3050, 8GB RAM", "M2 Chip, 16GB Unified Memory", "Core i9, RTX 4050, 32GB RAM", "Core i7, RTX 3080, 16GB RAM",
            "Core i5, Intel Iris Xe, 16GB RAM", "Core i7, Intel Iris Xe, 16GB RAM"
        )
        val dataPrice = arrayOf(
            "Rp 32.000.000", "Rp 28.500.000", "Rp 21.000.000", "Rp 25.000.000",
            "Rp 15.000.000", "Rp 35.000.000", "Rp 40.000.000", "Rp 45.000.000",
            "Rp 18.000.000", "Rp 30.000.000"
        )
        val dataDesc = arrayOf(
            "Laptop gaming premium dengan performa monster untuk game berat.",
            "Desain gagah dengan pendingin optimal untuk bermain game lama.",
            "Pilihan favorit gamers dengan harga to performance yang luar biasa.",
            "Desain minimalis tapi menyimpan tenaga besar di dalamnya.",
            "Laptop gaming entry-level yang sangat mumpuni untuk e-sports.",
            "Laptop profesional untuk editing video, programming, dan musik.",
            "Layar terbaik di kelasnya dengan bezel sangat tipis.",
            "Build quality berbahan metal yang sangat kokoh dan elegan.",
            "Laptop tipis dan ringan, cocok untuk mahasiswa dan pekerja.",
            "Laptop bisnis paling tangguh dengan keyboard paling nyaman."
        )

        val dataPhoto = intArrayOf(
            R.drawable.laptop1, R.drawable.laptop2, R.drawable.laptop3, R.drawable.laptop4,
            R.drawable.laptop5, R.drawable.laptop6, R.drawable.laptop7, R.drawable.laptop8,
            R.drawable.laptop9, R.drawable.laptop10
        )

        val listLaptop = ArrayList<Laptop>()
        for (i in dataName.indices) {
            val laptop = Laptop(dataName[i], dataSpecs[i], dataPrice[i], dataDesc[i], dataPhoto[i])
            listLaptop.add(laptop)
        }
        return listLaptop
    }

    private fun showRecyclerList() {
        rvLaptops.layoutManager = LinearLayoutManager(this)
        val laptopAdapter = LaptopAdapter(list)
        rvLaptops.adapter = laptopAdapter
    }
}