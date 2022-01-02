package fr.kittens.beecome

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showBack()
        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        //val textView = findViewById<TextView>(R.id.textViewName)
        val urlImage = intent.getStringExtra("urlImage")
        val textView = intent.getStringExtra("info")
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        Picasso.get().load(urlImage).into(imageView)
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("info", "a")
        intent.getStringExtra("info").let { setTitle(it) }
        intent.getStringExtra("nomprenom").let { setTitle(it) }
        intent.getStringExtra("email").let { setTitle(it) }
        intent.getStringExtra("groupe").let { setTitle(it) }
        intent.getStringExtra("urlschool").let { setTitle(it) }

    }
}