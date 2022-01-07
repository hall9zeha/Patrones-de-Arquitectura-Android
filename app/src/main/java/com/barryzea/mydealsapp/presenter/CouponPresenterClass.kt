package com.barryzea.mydealsapp.presenter

import com.barryzea.mydealsapp.model.Coupon
import com.barryzea.mydealsapp.model.CouponInteractor
import com.barryzea.mydealsapp.model.CouponInteractorClass
import com.barryzea.mydealsapp.view.CouponView

class CouponPresenterClass(var couponView:CouponView):CouponPresenter {
    private var couponInteractor= CouponInteractorClass(this)
    override fun getCoupons() {
        couponInteractor.getCoupon()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        couponView.showCoupons(coupons)
    }
}