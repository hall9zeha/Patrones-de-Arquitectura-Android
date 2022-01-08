package com.barryzea.mydealsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barryzea.mydealsapp.R
import com.barryzea.mydealsapp.databinding.ActivityMainBinding
import com.barryzea.mydealsapp.viewmodel.CouponViewModel


class MainActivity : AppCompatActivity(){
    private var viewModel:CouponViewModel?=null
    private lateinit var rvCoupons: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpDataBinding(savedInstanceState)


    }
    private fun setUpDataBinding(savedInstanceState: Bundle?){
        var dataBinding:com.barryzea.mydealsapp.databinding.ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel= ViewModelProvider(this).get(CouponViewModel::class.java)
        dataBinding.model=viewModel
        setUpListCoupons()
    }

    private fun setUpListCoupons() {
        viewModel?.callCoupons()
        viewModel?.getCoupons()?.observe(this, {
            viewModel?.setCouponInRecyclerAdapter(it)
        })
    }


}