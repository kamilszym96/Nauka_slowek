package com.example.slowkakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFrenchBinding

class FrenchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFrenchBinding


    private val dictionary = listOf(
        "das Haus" to "dom",
        "der Wagen" to "samochód",
        "der Hund" to "pies",
        "der Baum" to "drzewo",
        "der Stuhl" to "krzesło",
        "das Buch" to "książka",
        "der Computer" to "komputer",
        "das Wasser" to "woda",
        "die Sonne" to "słońce"
    )

    private var currentWordIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrenchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val (randomWord, translation) = dictionary[currentWordIndex]

        binding.foreignWordTextView.text = randomWord
        binding.translationTextView.text = translation

        binding.nextButton.setOnClickListener {
            currentWordIndex = (currentWordIndex + 1) % dictionary.size
            val (randomWord, translation) = dictionary[currentWordIndex]
            binding.foreignWordTextView.text = randomWord
            binding.translationTextView.text = translation
        }

        binding.toTest.setOnClickListener {
            val intent = Intent(this, TestFrenchActivity::class.java)
            startActivity(intent)
        }
    }
}