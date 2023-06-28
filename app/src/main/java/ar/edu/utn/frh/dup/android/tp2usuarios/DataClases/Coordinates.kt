package ar.edu.utn.frh.dup.android.tp2usuarios.DataClases

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Coordinates(
    val latitude: String,
    val longitude: String
)