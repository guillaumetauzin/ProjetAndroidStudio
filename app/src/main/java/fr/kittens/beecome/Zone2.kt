package fr.kittens.beecome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class Zone2 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone2)
        setHeaderTitle("Rayons")
        showBack()

        val categories = arrayListOf<Categorie>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoriesAdapter = CategorieAdapter(categories)
        recyclerView.adapter=categoriesAdapter

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
                        val categorie = Categorie(jsStudent.optString("category_id",""),
                            jsStudent.optString("title",""),
                            jsStudent.optString("products_url",""))
                        categories.add(categorie)
                        Log.d("Categorie ",categorie.title)
                    }
                    Log.d("Student","${categories.size}")


                    runOnUiThread(Runnable {
                        categoriesAdapter.notifyDataSetChanged()
                    })
                }
            }

        })
    }
}