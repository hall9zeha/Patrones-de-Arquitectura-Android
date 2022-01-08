package com.barryzea.mydealsapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CouponRepositoryClass(): CouponRepository {
    private var couponsLiveData:MutableLiveData<ArrayList<Coupon>> = MutableLiveData()
    override fun getCoupons(): MutableLiveData<ArrayList<Coupon>> {
        return couponsLiveData
    }

    override fun callCoupons() {
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
                couponsLiveData.value=coupons
            }
        })

    }
}