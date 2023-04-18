package com.example.slowkakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAngielskiBinding

import com.example.myapplication.databinding.ActivityTestGermanBinding

class TestGermanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestGermanBinding
    private var currentWordIndex = 0

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

    private var correctAnswersCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestGermanBinding.inflate(layoutInflater)
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