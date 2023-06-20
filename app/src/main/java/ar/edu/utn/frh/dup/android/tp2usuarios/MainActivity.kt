package ar.edu.utn.frh.dup.android.tp2usuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.utn.frh.dup.android.tp2usuarios.adapter.UserPrueba
import ar.edu.utn.frh.dup.android.tp2usuarios.adapter.UsuarioAdapter
import ar.edu.utn.frh.dup.android.tp2usuarios.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
    }

    private fun initRV(){

        binding.RVListaUsers.layoutManager = LinearLayoutManager(this)
        binding.RVListaUsers.adapter = UsuarioAdapter(UserPrueba.datosHarcodeados)

    }
}