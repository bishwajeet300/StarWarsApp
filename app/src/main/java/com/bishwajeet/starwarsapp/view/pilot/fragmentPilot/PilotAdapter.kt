package com.bishwajeet.starwarsapp.view.pilot.fragmentPilot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bishwajeet.starwarsapp.R
import com.bishwajeet.starwarsapp.model.entity.Pilot
import com.bishwajeet.starwarsapp.util.IAdapterItemListener

class PilotAdapter(private val iAdapterItemListener: IAdapterItemListener<Pilot>) :
    RecyclerView.Adapter<PilotAdapter.ViewHolder>() {

    var data = listOf<Pilot>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_pilot, parent, false) as CardView

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvName.text = item.name

        holder.tvName.setOnClickListener {
            iAdapterItemListener.onClick(item)
        }
    }


    override fun getItemCount() = data.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
    }
}