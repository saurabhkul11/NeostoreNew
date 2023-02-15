package com.example.neostorenew.view.activity.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.neostorenew.R
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityHomeScreenBinding
import com.example.neostorenew.view.activity.ProductList.ProductListActivity
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_home_screen.view.*

class DashBoardActivity:BaseActivity<ActivityHomeScreenBinding>(),View.OnClickListener {

    lateinit var binding: ActivityHomeScreenBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var imagelist:ArrayList<Int> = ArrayList()
        imagelist.add(R.drawable.slider_img1)
        imagelist.add(R.drawable.slider_img2)
        imagelist.add(R.drawable.slider_img3)
        imagelist.add(R.drawable.slider_img4)

        val navDrawer=binding.navDrawer

        var imagelistner = ImageListener{position, imageView -> imageView.setImageResource(imagelist[position]) }
        binding.carouselView.pageCount=imagelist.size
        binding.carouselView.setImageListener(imagelistner)

        toggle=ActionBarDrawerToggle(this,navDrawer,R.string.open,R.string.close)


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
                intent.putExtra("Category_value","3")
                startActivity(intent)
            }
            R.id.imgSofaIcon->{
                intent.putExtra("Category_value","2")
                startActivity(intent)

            }
            R.id.imgCupBoardIcon->{
                intent.putExtra("Category_value","4")
                startActivity(intent)

            }
            R.id.imgTableIcon->{
                intent.putExtra("Category_value","1")
                startActivity(intent)

            }
        }


    }


}


