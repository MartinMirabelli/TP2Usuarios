package ar.edu.utn.frh.dup.android.tp2usuarios.Service

import ar.edu.utn.frh.dup.android.tp2usuarios.DataClases.RandomUser
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private val retrofit = Retrofit.Builder()
    .baseUrl("https://randomuser.me/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

private val api  = retrofit.create(RandomUserAPI::class.java)

fun buscarUsuarios(
    callbackResultado: (RandomUser) -> Unit,
    callbackError: (Throwable) -> Unit
) {

    val call : Call<RandomUser> = api.obtenerUsuarios("us,dk,fr,gb",50,"female")

    call.enqueue( object : Callback<RandomUser>{
        override fun onResponse(call: Call<RandomUser>, response: Response<RandomUser>) {
            if (response.isSuccessful) {
                if (response.body() != null)
                    callbackResultado(response.body()!!)
                else {

                    onFailure(call, java.lang.NullPointerException("body nulo en respusta exitosa"))
                }
            }
            else
                onFailure(call,HttpException(response))
        }
        override fun onFailure(call: Call<RandomUser>, t: Throwable) {
            callbackError(t)
        }
    }

    )

}