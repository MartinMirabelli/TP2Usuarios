package ar.edu.utn.frh.dup.android.tp2usuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.utn.frh.dup.android.tp2usuarios.adapter.UserPrueba
import ar.edu.utn.frh.dup.android.tp2usuarios.adapter.UsuarioAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRV()
    }

    private fun initRV(){
        val recyclerView = findViewById<RecyclerView>(R.id.RV_ListaUsers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UsuarioAdapter(UserPrueba.datosHarcodeados)

    }
}