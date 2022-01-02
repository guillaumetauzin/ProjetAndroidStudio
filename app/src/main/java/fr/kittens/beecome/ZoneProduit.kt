package fr.kittens.beecome

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class ZoneProduit : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val product = intent.getStringExtra("product")
        setContentView(R.layout.activity_zone2)
        setHeaderTitle("Rayons")
        showBack()

        val produits = arrayListOf<Produit>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val produitsAdapter = ProduitAdapter(produits)
        recyclerView.adapter=produitsAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null){
                    val jsStudents = JSONObject(data)
                    val jsArrayStudents= jsStudents.getJSONArray("items")
                    for(i in 0 until jsArrayStudents.length()){
                        val jsStudent = jsArrayStudents.getJSONObject(i)
                        val produit = Produit(jsStudent.optString("name",""),
                            jsStudent.optString("description",""),
                            jsStudent.optString("picture_url",""))
                        produits.add(produit)
                        Log.d("Categorie ",produit.name)
                    }
                    Log.d("Student","${produits.size}")

                    //

                    runOnUiThread(Runnable {
                        produitsAdapter.notifyDataSetChanged()
                    })
                }
            }

        })
    }
}