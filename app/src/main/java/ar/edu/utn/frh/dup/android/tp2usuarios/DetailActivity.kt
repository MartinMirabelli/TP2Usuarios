package ar.edu.utn.frh.dup.android.tp2usuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.edu.utn.frh.dup.android.tp2usuarios.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_URL = "url"
        const val EXTRA_NOMBRE = "nombre"
        const val EXTRA_DIREC = "direc"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
    }

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val url = intent.getStringExtra(EXTRA_URL)
        val nombre = intent.getStringExtra(EXTRA_NOMBRE)
        val direc =  intent.getStringExtra(EXTRA_DIREC)
        val email =  intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)


        Glide.with(binding.IVfotoDetail.context).load(url).into(binding.IVfotoDetail)
        binding.TVnombreDetail.text = nombre
        binding.TVDirecionDetail.text = direc
        binding.TVEmailDetail.text = email
        binding.TVPhoneDetail.text = phone

    }

}