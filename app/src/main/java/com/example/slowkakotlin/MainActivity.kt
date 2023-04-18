package com.example.slowkakotlin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.slowkakotlin.AngielskiActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.engButton.setOnClickListener {
            val intent = Intent(this, AngielskiActivity::class.java)
            startActivity(intent)
        }

        binding.gerButton.setOnClickListener {
            val intent = Intent(this, GermanActivity::class.java)
            startActivity(intent)
        }

        binding.fraButton.setOnClickListener {
            val intent = Intent(this, FrenchActivity::class.java)
            startActivity(intent)
        }
    }
}
