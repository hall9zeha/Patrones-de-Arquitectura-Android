package com.barryzea.mydealsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barryzea.mydealsapp.model.ApiAdapter

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons)
        rvCoupons.layoutManager = LinearLayoutManager(this)
        var apiAdapter=ApiAdapter();
        val coupons = ArrayList<Coupon>()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()
        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
                t.stackTrace
            }
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons.add(coupon)
                }
                rvCoupons.adapter = RecyclerCouponsAdapter(coupons)
            }
        })

    }
}