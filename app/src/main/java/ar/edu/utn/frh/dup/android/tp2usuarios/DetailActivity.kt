package ar.edu.utn.frh.dup.android.tp2usuarios

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import ar.edu.utn.frh.dup.android.tp2usuarios.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_URL = "url"
        const val EXTRA_NOMBRE = "nombre"
        const val EXTRA_DIREC = "direc"
        const val EXTRA_EMAIL_APP = "email"
        const val EXTRA_PHONE = "phone"
        const val EXTRA_LATI = "lati"
        const val EXTRA_LONGI = "longi"
    }

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val url = intent.getStringExtra(EXTRA_URL)
        val nombre = intent.getStringExtra(EXTRA_NOMBRE)
        val direc =  intent.getStringExtra(EXTRA_DIREC)
        val email =  intent.getStringExtra(EXTRA_EMAIL_APP)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        val latitud = intent.getStringExtra(EXTRA_LATI)!!.toFloat()
        val longitud = intent.getStringExtra(EXTRA_LONGI)!!.toFloat()


        Glide.with(binding.IVfotoDetail.context).load(url).into(binding.IVfotoDetail)
        binding.TVnombreDetail.text = nombre
        binding.TVDirecionDetail.text = direc
        binding.TVEmailDetail.text = email
        binding.TVPhoneDetail.text = phone

        binding.TVPhoneDetail.setOnClickListener {
                if (phone != null) {
                    marcarNumero(phone)
                }
            }

        binding.TVDirecionDetail.setOnClickListener {
            if(latitud!=null && longitud != null){
                    verMapa(latitud,longitud)
            }

            }
        binding.TVEmailDetail.setOnClickListener {
            envia_mail(email!!)
            }
        }

        private fun marcarNumero(nroTelefono: String) {
        val intent = Intent(Intent.ACTION_DIAL)

        // Uri -> Universal Resource Identifier
        // "tel" es el _esquema_ de la Uri

        intent.data = Uri.parse("tel:$nroTelefono")
        startActivity(intent)
        }

    private fun verMapa(lat:Float, lon: Float) {

        val gmmIntentUri = Uri.parse("geo:$lat,$lon?q=$lat,$lon")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        val marker = "&markers=color:red%7Clabel:Location%7C$lat,$lon"
        gmmIntentUri?.buildUpon()?.appendQueryParameter("markers", marker)?.build()

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
        else
        {
            Toast.makeText(this, getString(R.string.no_map),Toast.LENGTH_SHORT).show()
        }
    }

    private fun envia_mail(email:String) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))  // espera un array de email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del TP2 ")
        intent.putExtra(Intent.EXTRA_TEXT, "Mensaje del TP2")
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, "Select email"))

    }

    }

