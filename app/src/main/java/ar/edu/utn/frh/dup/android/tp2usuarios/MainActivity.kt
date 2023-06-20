package ar.edu.utn.frh.dup.android.tp2usuarios

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.Result
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
        binding.RVListaUsers.adapter = UsuarioAdapter(UserPrueba.datosHarcodeados , ::itemClickeado)
    }

    private fun itemClickeado(usr: Result){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_URL, usr.picture.large)
        intent.putExtra(DetailActivity.EXTRA_NOMBRE, usr.name.first + " " +usr.name.last)
        intent.putExtra(DetailActivity.EXTRA_DIREC, usr.location.street.name + " " + usr.location.street.number + " " + usr.location.city+","+usr.location.country)
        intent.putExtra(DetailActivity.EXTRA_EMAIL, usr.email)
        intent.putExtra(DetailActivity.EXTRA_PHONE, usr.phone)

        startActivity(intent)
    }
}