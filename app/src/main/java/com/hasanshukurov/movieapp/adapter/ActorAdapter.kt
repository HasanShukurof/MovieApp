package com.hasanshukurov.movieapp.adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hasanshukurov.movieapp.data.actor.ActorItem
import com.hasanshukurov.movieapp.databinding.ActorRowBinding
import com.hasanshukurov.movieapp.view.TvShowFragmentDirections
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ActorAdapter (var actorList: List<ActorItem>): RecyclerView.Adapter<ActorAdapter.ActorHolder>() {
    class ActorHolder(val binding:ActorRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val binding = ActorRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ActorHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        val currentPosition = actorList[position]


        try {
            Picasso.get().load(currentPosition.image.original).into(holder.binding.imageViewActor)
            holder.binding.textViewActorName.text = currentPosition.name
            holder.binding.textViewActorCountry.text = currentPosition.country.name
        }catch (e:Exception){
            Log.e("Error","Data Error")
        }
    }

    override fun getItemCount(): Int {
        return actorList.size
    }


}