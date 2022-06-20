package com.example.leccionfragmentos.interface_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leccionfragmentos.Adaptador
import com.example.leccionfragmentos.databinding.ActivityListProductBinding
import com.example.leccionfragmentos.dto.Product
import com.example.leccionfragmentos.dto.WsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListProduct : AppCompatActivity() {

    private lateinit var views: ActivityListProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(views.root)
        initialConfiguration()
        addListProducts()
    }

    private fun initialConfiguration() {
        views.listItems.layoutManager = LinearLayoutManager(this)
    }

    private fun addListProducts() {
        WsClient.apiLista()?.buscarListaProductos()?.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val list = response.body()!!
                    views.listItems.adapter = Adaptador(list)
                } else {
                    Toast.makeText(
                        this@ListProduct,
                        android.R.string.httpErrorBadUrl,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(
                    this@ListProduct,
                    android.R.string.httpErrorBadUrl,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}