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
    }

    'okHttpClient.newCall(request).enqueue(object : Callback {
        'override fun onFailure(call: Call, e: IOException) {
            'TODO("Not yet implemented")
        '}
}