package fr.kittens.beecome

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){
    fun showBack(){
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    fun setHeaderTitle(text:String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text=text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Epsi","############ onCreate ###########"+ javaClass.simpleName)
    }


    override fun onStart() {
        super.onStart()
        Log.d("Epsi","############ onStart ###########"+ javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.d("Epsi","############ onResume ###########"+ javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.d("Epsi","############ onPause ###########"+ javaClass.simpleName)
    }


    override fun onStop() {
        super.onStop()
        Log.d("Epsi","############ onStop ###########"+ javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Epsi","############ onDestroy ###########"+ javaClass.simpleName)
    }
}