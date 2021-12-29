package fr.kittens.beecome

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.kittens.beecome.StudentAdapter.ViewHolder

class StudentAdapter(val student: ArrayList<Student>): RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewCity = view.findViewById<TextView>(R.id.textViewCity)
        val textViewZipcode = view.findViewById<TextView>(R.id.textViewZipcode)
        val textViewPhone = view.findViewById<TextView>(R.id.textViewPhone)
        val imageViewStudent = view.findViewById<ImageView>(R.id.imageViewStudent)
        val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_student, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = student.get(position)
        holder.textViewName.text=student.name
        holder.textViewEmail.text=student.email
        holder.textViewCity.text=student.city
        holder.textViewZipcode.text=student.zipcode
        holder.textViewPhone.text=student.phone
        holder.contentLayout.setOnClickListener(View.OnClickListener {
            (holder.contentLayout.context.applicationContext as AppKittens).showToast(student.name)
        })
    }

    override fun getItemCount(): Int {
        return student.size
    }
}