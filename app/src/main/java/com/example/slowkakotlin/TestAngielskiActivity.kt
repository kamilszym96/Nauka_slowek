package com.example.slowkakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAngielskiBinding
import com.example.myapplication.databinding.ActivityTestAngielskiBinding

class TestAngielskiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestAngielskiBinding
    private var currentWordIndex = 0
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

        private var correctAnswersCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestAngielskiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val (randomWord, translation) = dictionary[currentWordIndex]

        binding.foreignWordTextView.text = randomWord


        binding.checkButton.setOnClickListener {
            val answer = binding.answer.text.toString()
            val correctTranslation = dictionary[currentWordIndex].second
            if (answer == correctTranslation) {
                binding.checkText.text = "Poprawnie!"
                correctAnswersCount++
            } else {
                binding.checkText.text = "Źle. \nPoprawne tłumaczenie: \n$correctTranslation"
            }
        }

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            if(currentWordIndex == dictionary.lastIndex +1) {
                finish()
                startActivity(intent)
            }
            else if (currentWordIndex == dictionary.lastIndex) {
                binding.nextButton.text = "Zakończ"
                binding.checkText.text = "Wynik: $correctAnswersCount/${dictionary.size}"
                binding.foreignWordTextView.text = ""
                binding.checkButton.isEnabled = false
                binding.answer.isEnabled = false
                currentWordIndex++

            } else {
                currentWordIndex++
                val (randomWord, translation) = dictionary[currentWordIndex]
                binding.foreignWordTextView.text = randomWord
                binding.checkText.text = ""
                binding.answer.text.clear()
            }
        }
    }
}