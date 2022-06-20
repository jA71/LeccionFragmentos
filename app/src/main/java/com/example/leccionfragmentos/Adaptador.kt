package com.example.leccionfragmentos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leccionfragmentos.databinding.FragmentProductBinding
import com.example.leccionfragmentos.dto.Product
import com.squareup.picasso.Picasso

class Adaptador(val lista: List<Product>) : RecyclerView.Adapter<Adaptador.ProductHolder>() {

    inner class ProductHolder(fragmentoView: View) : RecyclerView.ViewHolder(fragmentoView) {

        var viewsFragmentHolder: FragmentProductBinding

        init {
            viewsFragmentHolder = FragmentProductBinding.bind(fragmentoView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return ProductHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.viewsFragmentHolder.marca.text = lista[position].marca
        holder.viewsFragmentHolder.descripcion.text = lista[position].modelo
        holder.viewsFragmentHolder.capacidad.text = lista[position].capacidad.toString()
        holder.viewsFragmentHolder.placas.text = lista[position].placas
        holder.viewsFragmentHolder.precio.text = lista[position].descripcion
        Picasso.get().load(lista[position].url).fit().centerInside().into(holder.viewsFragmentHolder.image)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}