package com.barryzea.mydealsapp.model

import androidx.lifecycle.MutableLiveData

interface CouponRepository {
    fun callCoupons()
    fun getCoupons():MutableLiveData<ArrayList<Coupon>>
}