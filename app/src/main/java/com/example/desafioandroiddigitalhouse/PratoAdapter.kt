package com.example.desafioandroiddigitalhouse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PratoAdapter(private val listPratos: ArrayList<Prato>, val listener: PratoAdapter.OnPratoClickListener): RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratoAdapter.PratoViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_food, parent, false);

        return PratoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratoAdapter.PratoViewHolder, position: Int) {
        var prato = listPratos.get(position)

        holder.tvNomePrato.text = prato.nome
        holder.ivPrato.setImageResource(prato.foto)

    }

    interface OnPratoClickListener{
        fun pratoClick(position: Int)
    }

    override fun getItemCount() = listPratos.size

    inner class PratoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)
        val ivPrato: ImageView = itemView.findViewById(R.id.ivPrato)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.pratoClick(position)
        }
    }

}