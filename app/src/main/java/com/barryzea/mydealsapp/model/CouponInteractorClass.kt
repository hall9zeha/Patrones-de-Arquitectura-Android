package com.barryzea.mydealsapp.model

import com.barryzea.mydealsapp.presenter.CouponPresenter

class CouponInteractorClass(couponPresenter:CouponPresenter):CouponInteractor {
    private var couponRepository=CouponRepositoryClass(couponPresenter)
    override fun getCoupon() {
        couponRepository.getCoupons()
    }
}