package com.example.storybook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private lateinit var ivAnimal: ImageView
    private lateinit var tvStory: TextView
    private lateinit var btNext1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        ivAnimal = findViewById(R.id.ivAnimal)
        tvStory = findViewById(R.id.tvStory)
        btNext1 = findViewById(R.id.btNext1)

        val Name = intent.getStringExtra("Name")
        val Religion = intent.getStringExtra("Religion")
        val Location = intent.getStringExtra("Location")
        val Animal = intent.getStringExtra("Animal")

        when (Animal) {
            "კუ" -> ivAnimal.setImageResource(R.drawable.ku)
            "ნიამორი" -> ivAnimal.setImageResource(R.drawable.niamori)
            "იხვნისკარტა" -> ivAnimal.setImageResource(R.drawable.ikhvniskarta)
            "თახვი" -> ivAnimal.setImageResource(R.drawable.takhvi)
            "ძლოკვი" -> ivAnimal.setImageResource(R.drawable.dzlokvi)
            "ქაიხოსრო (ქაქუცა)" -> ivAnimal.setImageResource(R.drawable.qaqutsa)
            "თრითინა" -> ivAnimal.setImageResource(R.drawable.tritina)
        }

        tvStory.text = "იყო და არა იყო რა. ულამაზესი ადგილი იყო $Location. ჩიტები ჭიკჭიკებდნენ, საამური" +
                " დილა იყო, როდესაც სახლი დატოვა ჩვენმა მთავარმა პერსონაჟმა (რომელიც იყო $Animal). მას ერქვა $Name. იგი" +
                " $Religion იყო და ამაყობდა კიდეც ამით. ყოველ დილით იგი ჩამოუვლიდა მეზობლებს და იტყოდა ხოლმე:" +
                "\"დიახ, დიახ, მე $Religion ვარ, მე $Religion ვარ, ოპა განგნამ სტაილ.\" ხანდახან იგი ამ პროცესს დღეში " +
                "რვაჯერაც იმეორებდა ხოლმე, აბა, მეტი რა საქმე ქონდა? ასე გადიოდა წლები, მსოფლიო იცვლებოდა, იმპერიები " +
                "ეცემოდნენ და მათ ადგილს ახალი სახელმწიფოები იკავებდნენ, $Name კი ${Name}-ად რჩებოდა. ჭირი იქა, " +
                "ქატო იქა, ფქვილი იქა და ბარემ ლხინიც იქა!"

        btNext1.setOnClickListener {
            intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}