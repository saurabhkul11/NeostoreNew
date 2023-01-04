package com.example.neostorenew.view.activity.ProductList

import android.view.LayoutInflater
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityProductListBinding

class ProductListActivity:BaseActivity<ActivityProductListBinding>() {

    lateinit var binding: ActivityProductListBinding
    override fun inflateLayout(layoutInflater: LayoutInflater)= ActivityProductListBinding.inflate(layoutInflater)

    override fun applyUI(pbinding: ActivityProductListBinding) {
        binding=pbinding
    }
}