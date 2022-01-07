package com.barryzea.mydealsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barryzea.mydealsapp.model.Coupon
import com.barryzea.mydealsapp.R
import com.barryzea.mydealsapp.model.ApiAdapter
import com.barryzea.mydealsapp.presenter.CouponPresenter
import com.barryzea.mydealsapp.presenter.CouponPresenterClass

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {
    private var couponPresenter: CouponPresenter?=null
    private lateinit var rvCoupons: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        couponPresenter=CouponPresenterClass(this)
        getCoupons()
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons.layoutManager = LinearLayoutManager(this)


    }

    override fun getCoupons() {
       couponPresenter?.getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
       rvCoupons.adapter=RecyclerCouponsAdapter(coupons)
    }
}