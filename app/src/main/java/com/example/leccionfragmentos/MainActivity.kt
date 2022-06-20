package com.example.leccionfragmentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.leccionfragmentos.databinding.ActivityMainBinding
import com.example.leccionfragmentos.dto.User
import com.example.leccionfragmentos.dto.WsClient
import com.example.leccionfragmentos.interface_user.ListProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.logInBtn.setOnClickListener {
            var usuario = User()
            usuario.usuario = views.user.text.toString().trim()
            usuario.clave = views.user.text.toString().trim()
            WsClient.apiLogeo()?.logearse(usuario)?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful && !response.body().toString().isEmpty()){
                        val intent = Intent ( this@MainActivity, ListProduct::class.java)
                        startActivity(intent)
                    }else {
                        Toast.makeText(this@MainActivity, "Clave erronea", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message.toString(), Toast.LENGTH_SHORT).show()
                }

            })
            //showData()
        }
    }
}