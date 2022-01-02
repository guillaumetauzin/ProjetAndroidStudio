package fr.kittens.beecome

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class Zone1 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone1)
        val buttonEtudiant1 = findViewById<Button>(R.id.button_etudiant_1)
        val buttonEtudiant2 = findViewById<Button>(R.id.button_etudiant_2)
        val buttonEtudiant3 = findViewById<Button>(R.id.button_etudiant_3)
        buttonEtudiant1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title","Etudiant 1")
            newIntent.putExtra("info","Etudiant 1")
            newIntent.putExtra("nomprenom","Jean Pierre")
            newIntent.putExtra("email","Groupe1@gmail.com")
            newIntent.putExtra("groupe","Groupe 1")
            newIntent.putExtra("urlschool","http://www.epsi.fr")
            newIntent.putExtra("urlImage","https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg")
            startActivity(newIntent)
        })

        buttonEtudiant2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title","Etudiant 2")
            newIntent.putExtra("urlImage","https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/2/3/1/2310c9171a_50157784_pia23441.jpg")
            startActivity(newIntent)
        })

        buttonEtudiant3.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title","Etudiant 3")
            newIntent.putExtra("urlImage","https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg")
            startActivity(newIntent)
        })

    }
}