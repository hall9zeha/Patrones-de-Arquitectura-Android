package com.barryzea.mydealsapp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.barryzea.mydealsapp.myApp.myApp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.util.zip.Inflater

class RecyclerCouponsAdapter(var coupons: ArrayList<Coupon>) : RecyclerView.Adapter<RecyclerCouponsAdapter.CouponsHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.card_coupon,parent,false)
        return CouponsHolder(view)
    }

    override fun onBindViewHolder(holder: CouponsHolder, position: Int) {
        holder.setDataCard(coupons[position])
    }

    override fun getItemCount(): Int {
        return  if(coupons.size>0) coupons.size else 0
    }

    class CouponsHolder (v:View):RecyclerView.ViewHolder(v), View.OnClickListener{

        private var coupon: Coupon? = null
        private var imgCoupon: ImageView = v.findViewById(R.id.imgCoupon)
        private var tvTitle: TextView = v.findViewById(R.id.tvTitle)
        private var tvDescriptionShort: TextView = v.findViewById(R.id.tvDescriptionShort)
        private var tvCategory: TextView = v.findViewById(R.id.tvCategory)
        private var tvDate: TextView = v.findViewById(R.id.tvDate)

        override fun onClick(v: View?) {
            Log.i("CLICK Coupon: ", coupon!!.title)
            val context = v!!.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupon)
            context.startActivity(showPhotoIntent)
        }
        init {
            v.setOnClickListener(this)
        }

        fun setDataCard(coupon: Coupon){
            this.coupon = coupon
            Glide.with(myApp.context!!).load(coupon.image_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(520, 520).centerCrop().into(imgCoupon)
            tvTitle.text = coupon.title
            tvDescriptionShort.text = coupon.descriptionShort
            tvCategory.text = coupon.category
            tvDate.text = coupon.endDate

        }



    }
}
