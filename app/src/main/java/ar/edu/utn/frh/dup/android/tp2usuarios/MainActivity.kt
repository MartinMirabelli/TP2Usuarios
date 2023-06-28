package ar.edu.utn.frh.dup.android.tp2usuarios

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.Result
import ar.edu.utn.frh.dup.android.tp2usuarios.Service.buscarUsuarios
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

        // creo esta lambda que tiene los callback creado en buscarUsuarios

        buscarUsuarios (
            {datos -> binding.RVListaUsers.adapter = UsuarioAdapter(datos , ::itemClickeado)
                binding.FLProgresBar.visibility = View.GONE  // ya se pinto oculto la ProgressBar
            } ,
            { t -> val errMsg = if (t is java.lang.Exception)
                        getString(R.string.exc_msg)
                    else
                        getString(R.string.err_msg)

                binding.FLProgresBar.visibility = View.GONE
                Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun itemClickeado(usr: Result){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_URL, usr.picture.large)
        intent.putExtra(DetailActivity.EXTRA_NOMBRE, usr.name.first + " " +usr.name.last + " ("+usr.dob.age+")")
        intent.putExtra(DetailActivity.EXTRA_DIREC, usr.location.street.name + " " + usr.location.street.number + " " + usr.location.city+", "+usr.location.country)
        intent.putExtra(DetailActivity.EXTRA_EMAIL_APP, usr.email)
        intent.putExtra(DetailActivity.EXTRA_PHONE, usr.phone)

        intent.putExtra(DetailActivity.EXTRA_LATI, usr.location.coordinates.latitude)
        intent.putExtra(DetailActivity.EXTRA_LONGI, usr.location.coordinates.longitude)

        startActivity(intent)
    }

}