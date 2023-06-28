package ar.edu.utn.frh.dup.android.tp2usuarios.DataClases

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)

data class Name(
    val first: String,
    val last: String,
    val title: String
)