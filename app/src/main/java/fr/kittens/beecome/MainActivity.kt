package fr.kittens.beecome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonzone1 = findViewById<Button>(R.id.button_zone_1)
        val buttonzone2 = findViewById<Button>(R.id.button_zone_2)
        buttonzone1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupeInfoActivity::class.java)
            startActivity(newIntent)
        })

        buttonzone2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,RayonsActivity::class.java)
            startActivity(newIntent)
        })

    }
}