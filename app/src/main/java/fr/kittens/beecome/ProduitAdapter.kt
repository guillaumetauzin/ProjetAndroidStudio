package fr.kittens.beecome

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.kittens.beecome.ProduitAdapter.ViewHolder

class ProduitAdapter(val produit: ArrayList<Produit>): RecyclerView.Adapter<ViewHolder>() {

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
        val categorie = produit.get(position)
        holder.textViewName.text=categorie.name
        //holder.textViewEmail.text=student.products_url
        //holder.textViewCity.text=student.title

        holder.contentLayout.setOnClickListener(View.OnClickListener {
            Log.d("Id:", categorie.name)
            Log.d("Image:", categorie.picture_url)
            //(holder.contentLayout.context.applicationContext as AppKittens).showToast(categorie.products_url)

        })
    }

    override fun getItemCount(): Int {
        return produit.size
    }
}