package springforandroid.pactpub.sunnat629.basicauthinkotlin.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder()
        .client(getOkHttpClient())
        .baseUrl(JSON_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

private fun getOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(USER_NAME, PASSWORD))
            .build()
}

object UserDataApi {
    val retrofitService: UserDataApiService by lazy {
        retrofit.create(UserDataApiService::class.java)
    }
}