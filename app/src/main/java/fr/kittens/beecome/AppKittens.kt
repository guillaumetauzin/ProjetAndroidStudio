package fr.kittens.beecome

import android.app.Application
import android.widget.Toast

class AppKittens : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    fun showToast(txt : String){
        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show()
    }
}