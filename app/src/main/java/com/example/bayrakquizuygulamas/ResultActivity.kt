package com.example.bayrakquizuygulamas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bayrakquizuygulamas.databinding.ActivityMainBinding
import com.example.bayrakquizuygulamas.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dogruSayac = intent.getIntExtra("dogruSayac",0)

        binding.textViewSonuc.text = "$dogruSayac DOĞRU ${5-dogruSayac} YANLIŞ"

        binding.textViewYuzdeSonuc.text = "% ${(dogruSayac*100)/5} Başarı"


        binding.buttonTekrar.setOnClickListener {

            startActivity(Intent(this@ResultActivity,QuizActivity::class.java))
            /*finish ile beraber backstage den bu activityi siliyoruz şöyle ki
            Önce Quizden Resulta geçiyoruz button ile resultta geri tıklayınca quize geri döner normalde
            çünkü backstage den silmiyoruz fakat resulttan quize button ile döndüğümüzde backstage den silmezsek
            geriye tıklayınca tekrar resulta gider bu yüzden finish kullanıyoruz ^^
            */
            finish()

        }

    }
}