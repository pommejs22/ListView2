package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityMainBinding
import com.example.listview.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getIntExtra("image", R.drawable.girl_13)
        val name = intent.getStringExtra("name")
        val massage = intent.getStringExtra("massage")
        val massageTime = intent.getStringExtra("massageTime")

        binding.subImage.setImageResource(image)
        binding.subName.text = name
        binding.subMassage.text = massage
        binding.subMassageTime.text = massageTime

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}