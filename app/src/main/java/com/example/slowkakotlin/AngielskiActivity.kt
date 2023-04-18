package com.example.slowkakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAngielskiBinding

class AngielskiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAngielskiBinding


    private val dictionary = listOf(
        "house" to "dom",
        "car" to "samochód",
        "dog" to "pies",
        "tree" to "drzewo",
        "chair" to "krzesło",
        "book" to "książka",
        "computer" to "komputer",
        "water" to "woda",
        "sun" to "słońce"
    )

    private var currentWordIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAngielskiBinding.inflate(layoutInflater)
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
            val intent = Intent(this, TestAngielskiActivity::class.java)
            startActivity(intent)
        }
    }
}