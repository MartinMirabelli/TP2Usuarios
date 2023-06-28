package ar.edu.utn.frh.dup.android.tp2usuarios.Service

import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.RandomUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


//  https://randomuser.me/api/?nat=us,dk,fr,gb&results=25&gender=female  //por ejemplo

interface RandomUserAPI {
    @GET("api/")
    fun obtenerUsuarios(
            @Query("nat") nat:String,
            @Query("results") results: Int,
            @Query("gender") gender:String

    ): Call<RandomUser>

}