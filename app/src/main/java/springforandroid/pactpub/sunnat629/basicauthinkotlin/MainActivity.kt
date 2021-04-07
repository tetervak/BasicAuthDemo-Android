package springforandroid.pactpub.sunnat629.basicauthinkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import springforandroid.pactpub.sunnat629.basicauthinkotlin.adapter.UserListAdapter
import springforandroid.pactpub.sunnat629.basicauthinkotlin.databinding.ActivityMainBinding
import springforandroid.pactpub.sunnat629.basicauthinkotlin.model.User
import springforandroid.pactpub.sunnat629.basicauthinkotlin.network.UserDataApi


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call: Call<List<User>> = UserDataApi.retrofitService.getUserList()
        call.enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("PACKTPUB", t.message ?: "Could not load the user list")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val adapter = UserListAdapter(this@MainActivity, response.body())
                binding.displayList.adapter = adapter
            }
        })
    }
}
