package ar.edu.utn.frh.dup.android.tp2usuarios.DataClases

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)