package com.barryzea.mydealsapp.view

import com.barryzea.mydealsapp.model.Coupon

interface CouponView {
    fun getCoupons()
    fun showCoupons(coupons:ArrayList<Coupon>)
}