package ar.edu.utn.frh.dup.android.tp2usuarios.adapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.RandomUser
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.Result

import ar.edu.utn.frh.dup.android.tp2usuarios.R
import ar.edu.utn.frh.dup.android.tp2usuarios.Usuarios
import ar.edu.utn.frh.dup.android.tp2usuarios.databinding.ItemContenidoBinding
import com.bumptech.glide.Glide

class UsuarioViewHolder(view: View ) : ViewHolder(view){

    val binding = ItemContenidoBinding.bind(view)

    fun render(usr : Result){
        binding.TVnombre.text = usr.name.first+ " "+usr.name.last
        binding.TVciudad.text = usr.location.city
        binding.TVpais.text = usr.location.country

        Glide.with(binding.IVfoto.context).load(usr.picture.medium).into(binding.IVfoto)

    }


}