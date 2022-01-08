package com.barryzea.mydealsapp.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {
    private var couponRepository = CouponRepositoryClass()
    fun callCoupons(){
        couponRepository.callCoupons()
    }
    fun getCoupons():MutableLiveData<ArrayList<Coupon>>{
        return couponRepository.getCoupons()
    }
}