package fr.kittens.beecome

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class zone2 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zone2)
        setHeaderTitle("Category")
        showBack()

        val testView
        testView.layoutManager = LinearLayoutManager(this)

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="http://djemam.com/epsi/categories.json"
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
                        val category = Student(jsStudent.optString("title",""),
                            jsStudent.optString("email",""),
                            jsStudent.optString("products_url",""),jsStudent.optString("phone",""),jsStudent.optString("city",""),jsStudent.optString("zipcode",""))
                        categories.add(category)
                        Log.d("student",category.name)
                    }
                }
            }

        })
    }
}