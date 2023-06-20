package ar.edu.utn.frh.dup.android.tp2usuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.utn.frh.dup.android.tp2usuarios.adapter.UserPrueba
import ar.edu.utn.frh.dup.android.tp2usuarios.adapter.UsuarioAdapter
import ar.edu.utn.frh.dup.android.tp2usuarios.databinding.ActivityMainBinding
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.Result

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
        binding.RVListaUsers.adapter = UsuarioAdapter(UserPrueba.datosHarcodeados , ::contenidoClickeado)

    }

    private fun contenidoClickeado(usr: Result){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_URL, usr.picture.large)
        intent.putExtra(DetailActivity.EXTRA_NOMBRE, usr.name.first)
        startActivity(intent)
    }
}