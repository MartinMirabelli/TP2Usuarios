package ar.edu.utn.frh.dup.android.tp2usuarios.adapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ar.edu.utn.frh.dup.android.tp2usuarios.R
import ar.edu.utn.frh.dup.android.tp2usuarios.Usuarios

class UsuarioViewHolder(view: View ) : ViewHolder(view){

    val nombre = view.findViewById<TextView>(R.id.TVnombre)
    val ciudad = view.findViewById<TextView>(R.id.TVciudad)
    val pais = view.findViewById<TextView>(R.id.TVpais)
    val foto = view.findViewById<ImageView>(R.id.IVfoto)

    fun render(usr : Usuarios){
        nombre.text = usr.name
        ciudad.text = usr.city
        pais.text = usr.country

    }


}