package com.example.neostorenew.view.activity.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.neostorenew.R
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityHomeScreenBinding
import com.example.neostorenew.view.activity.ProductList.ProductListActivity
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_home_screen.view.*

class DashBoardActivity:BaseActivity<ActivityHomeScreenBinding>(),View.OnClickListener {

    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var imagelist:ArrayList<Int> = ArrayList()
        imagelist.add(R.drawable.slider_img1)
        imagelist.add(R.drawable.slider_img2)
        imagelist.add(R.drawable.slider_img3)
        imagelist.add(R.drawable.slider_img4)

        var imagelistner = ImageListener{position, imageView -> imageView.setImageResource(imagelist[position]) }


        binding.carouselView.pageCount=imagelist.size
        binding.carouselView.setImageListener(imagelistner)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityHomeScreenBinding.inflate(layoutInflater)

    override fun applyUI(dbinding: ActivityHomeScreenBinding) {
        binding = dbinding
    }

    override fun onClick(v: View) {
        val intent=Intent(this,ProductListActivity::class.java)
        when(v.id){
            R.id.imgChairIcon->{

            }
            R.id.imgSofaIcon->{

            }
            R.id.imgCupBoardIcon->{

            }
            R.id.imgTableIcon->{

            }
        }


    }


}


