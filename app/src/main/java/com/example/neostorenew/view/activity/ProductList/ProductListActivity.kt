package com.example.neostorenew.view.activity.ProductList

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityProductListBinding
import javax.inject.Inject

class ProductListActivity:BaseActivity<ActivityProductListBinding>() {

    lateinit var binding: ActivityProductListBinding
    @Inject
    lateinit var viewModel: ProductListViewModel
    @Inject
    lateinit var productListViewModelFactory: ProductListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var title=binding.productToolbarTitle.text
        val category=intent.getStringExtra("Category_value")
        when(category){
            "1"->{
                title="Tables"
                viewModel.productList("1")
            }
            "2"->{
                title="Sofas"
                viewModel.productList("2")
            }
            "3"->{
                title="Chairs"
                viewModel.productList("3")
            }
            "4"->{
                title="CupBoards"
                viewModel.productList("4")
            }
        }

        viewModel=ViewModelProvider(this,productListViewModelFactory).get(ProductListViewModel::class.java)
        viewModel.productlistdata.observe(this, Observer {
                if (it.status==200){

                }
        })

    }

    override fun inflateLayout(layoutInflater: LayoutInflater)= ActivityProductListBinding.inflate(layoutInflater)

    override fun applyUI(pbinding: ActivityProductListBinding) {
        binding=pbinding
    }

}