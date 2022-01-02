package fr.kittens.beecome

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.kittens.beecome.CategorieAdapter.ViewHolder

class CategorieAdapter(val categorie: ArrayList<Categorie>): RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textCategorie)
        //val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        //val textViewCity = view.findViewById<TextView>(R.id.textViewCity)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout2)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_categorie, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categorie = categorie.get(position)
        holder.textViewName.text=categorie.title
        //holder.textViewEmail.text=student.products_url
        //holder.textViewCity.text=student.title

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            Log.d("URL des produits", categorie.products_url)

        })
    }

    override fun getItemCount(): Int {
        return categorie.size
    }
}