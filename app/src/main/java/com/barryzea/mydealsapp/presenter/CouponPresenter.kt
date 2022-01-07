package com.barryzea.mydealsapp.presenter

import com.barryzea.mydealsapp.model.Coupon

interface CouponPresenter {
    fun getCoupons()
    fun showCoupons(coupons:ArrayList<Coupon>)
}