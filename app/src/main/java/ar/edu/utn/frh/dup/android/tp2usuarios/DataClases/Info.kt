package ar.edu.utn.frh.dup.android.tp2usuarios.DataClases

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)