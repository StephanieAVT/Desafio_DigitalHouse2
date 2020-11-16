package com.example.desafioandroiddigitalhouse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter(private val listRestaurantes: ArrayList<Restaurante>, val listener: HomeActivity): RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestauranteAdapter.RestauranteViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_restaurant, parent, false);
        return RestauranteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauranteAdapter.RestauranteViewHolder, position: Int) {
        var restaurante = listRestaurantes.get(position)
//        Picasso.get().load(listRestaurantes[position].foto).into(holder.ivRestaurante)

        holder.tvNome.text = restaurante.nome
        holder.tvEndereco.text = restaurante.endereco
        holder.tvHorario.text = restaurante.horario
        holder.ivRestaurante.setImageResource(restaurante.foto)
    }

    interface OnRestauranteClickListener{
        fun restauranteClick(position: Int)
    }

    override fun getItemCount() = listRestaurantes.size

    inner class RestauranteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvNome: TextView = itemView.findViewById(R.id.tvTitle)
        val tvEndereco: TextView = itemView.findViewById(R.id.tvAdress)
        val tvHorario: TextView = itemView.findViewById(R.id.tvHour)
        val ivRestaurante: ImageView = itemView.findViewById(R.id.ivImageRestaurant)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position)
                listener.restauranteClick(position)
        }
    }
}
