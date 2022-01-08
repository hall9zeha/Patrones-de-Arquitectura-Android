package com.barryzea.mydealsapp.view

import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.barryzea.mydealsapp.BR
import com.barryzea.mydealsapp.R
import com.barryzea.mydealsapp.model.Coupon
import com.barryzea.mydealsapp.model.OnItemClickListener
import com.barryzea.mydealsapp.myApp.myApp
import com.barryzea.mydealsapp.view.CouponDetailActivity
import com.barryzea.mydealsapp.viewmodel.CouponViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class RecyclerCouponsAdapter(var viewModel: CouponViewModel) : RecyclerView.Adapter<RecyclerCouponsAdapter.CouponsHolder>() {
    private var coupons:ArrayList<Coupon>?=null
    fun setUpAdapter(coupons: ArrayList<Coupon>){
        this.coupons=coupons
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        var binding:ViewDataBinding=DataBindingUtil.inflate(layoutInflater,viewType,parent, false)

        return CouponsHolder(binding)
    }

    override fun onBindViewHolder(holder: CouponsHolder, position: Int) {
        coupons?.get(position)?.let { holder.setDataCard(viewModel,position) }

    }

    override fun getItemCount(): Int {
        return  coupons?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutForId(position)
    }
    fun getLayoutForId(position:Int):Int{
        return R.layout.card_coupon
    }
    class CouponsHolder (v:ViewDataBinding):RecyclerView.ViewHolder(v.root),OnItemClickListener{

       private var binding:ViewDataBinding?=null
        init{
            this.binding=v
        }


        fun setDataCard(viewModelCoupon:CouponViewModel, position:Int){
            binding?.setVariable(BR.model,viewModelCoupon)
            binding?.setVariable(BR.position,position)
            binding?.setVariable(BR.clickListener,this)
            binding?.executePendingBindings()


        }

        override fun onClickItem(coupon: Coupon) {

          val showPhotoIntent = Intent(myApp.context, CouponDetailActivity::class.java)
          showPhotoIntent.putExtra("COUPON", coupon)
          myApp.context.startActivity(showPhotoIntent)
        }


    }
}
