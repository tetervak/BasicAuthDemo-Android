package springforandroid.pactpub.sunnat629.basicauthinkotlin.network

import retrofit2.Call
import retrofit2.http.GET
import springforandroid.pactpub.sunnat629.basicauthinkotlin.model.User

interface UserDataApiService {
    @GET("/users")
    fun getUserList(): Call<List<User>>
}