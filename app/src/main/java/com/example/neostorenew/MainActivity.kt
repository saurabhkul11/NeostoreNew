package com.example.neostorenew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun showToast(message: String) {
        super.showToast("MainActivity")
    }


    override fun inflateLayout(layoutInflater: LayoutInflater)= ActivityMainBinding.inflate(layoutInflater)
    override fun applyUI(binding: ActivityMainBinding) {
    }

}

