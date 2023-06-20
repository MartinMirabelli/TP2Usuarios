package ar.edu.utn.frh.dup.android.tp2usuarios.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.RandomUser
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.Result

import ar.edu.utn.frh.dup.android.tp2usuarios.R
import ar.edu.utn.frh.dup.android.tp2usuarios.Usuarios

class UsuarioAdapter(private val listaUsuarios : RandomUser , private val contenidoClikeado: (Result) -> Unit ) : RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_contenido, parent , false))

    }
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = listaUsuarios.results[position]
        holder.render(item)

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                contenidoClikeado(item)
            }
        })

    }
    override fun getItemCount(): Int = listaUsuarios.results.size

}



