package com.barryzea.mydealsapp.viewmodel

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.barryzea.mydealsapp.model.Coupon
import com.barryzea.mydealsapp.model.CouponObservable
import com.barryzea.mydealsapp.view.RecyclerCouponsAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel : ViewModel() {
    private var couponObservable = CouponObservable()
    private var couponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons() {
        couponObservable.callCoupons()
    }

    fun getCoupons(): MutableLiveData<ArrayList<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCouponInRecyclerAdapter(coupons: ArrayList<Coupon>) {
        couponsAdapter?.setUpAdapter(coupons)
        couponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerViewAdapter(): RecyclerCouponsAdapter {
        couponsAdapter = RecyclerCouponsAdapter(this)
        return couponsAdapter!!
    }

    fun getCouponForViewModel(position: Int): Coupon? {
        var coupon = couponObservable.getCoupons().value
        return coupon?.get(position)
    }

    /*
    * para bindear una imágen a través de glide o picasso debemos usar app:"y un nombre cualquiera", en logar
    * de src o si quieres también src, para poderlo llamar con el decorador @BindingAdapter("cualquier nombre")
    * y en el xml pasarle por la url como esta app:src="@{model.urlImage}", luego este método hara su magia
    * */
    companion object {
        @JvmStatic
    @BindingAdapter("src")
    fun loadBackgroundImage(view: CircleImageView, imageUrl: String?) {
        imageUrl?.let {
            Glide.with(view.context).load(imageUrl).into(view)
        }
    }
}
    @BindingAdapter("onClickListener")
    fun onClickCardView(view:CardView,coupon: Coupon){
        Toast.makeText(view.context, coupon.image_url, Toast.LENGTH_SHORT).show()
    }
}