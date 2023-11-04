package com.example.videojuegos.visualpresentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroescomics.R
import com.example.superheroescomics.data.local.list.SuperHeroEntity
import com.example.superheroescomics.databinding.ItemListBinding
import com.example.videojuegos.data.data.local.list.VideojuegoEntity

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private lateinit var itemBinding: ItemListBinding
    private val listOfVideo = mutableListOf<VideojuegoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        itemBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return ListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val superHero = listOfVideo[position]
        holder.bind(superHero)
    }

    override fun getItemCount(): Int {
        return listOfVideo.size
    }

    fun setData(cellPhones: List<VideojuegoEntity>) {
        this.listOfVideo.clear()
        this.listOfVideo.addAll(cellPhones)
        notifyDataSetChanged()
    }

    class ListViewHolder(private val itemBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(superHero: VideojuegoEntity) {
            itemBinding.imageViewItem.load(superHero.imageUrl){
                placeholder(R.drawable.loading_white)
               .error(R.drawable.image_not_available_white)
            }
            itemBinding.tvNameItem.text = superHero.name.uppercase()
            itemBinding.cvItemList.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("id", superHero.id.toString())
                Navigation.findNavController(itemBinding.root).navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }
}