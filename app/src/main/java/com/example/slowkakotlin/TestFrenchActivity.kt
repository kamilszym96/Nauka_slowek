package com.example.slowkakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import com.example.myapplication.databinding.ActivityTestFrenchBinding

class TestFrenchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestFrenchBinding
    private var currentWordIndex = 0

    private val dictionary = listOf(
        "la maison" to "dom",
        "la voiture" to "samochód",
        "le chien" to "pies",
        "l'arbre" to "drzewo",
        "la chaise" to "krzesło",
        "le livre" to "książka",
        "l'ordinateur" to "komputer",
        "l'eau" to "woda",
        "la soleil" to "słońce"
    )

    private var correctAnswersCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestFrenchBinding.inflate(layoutInflater)
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