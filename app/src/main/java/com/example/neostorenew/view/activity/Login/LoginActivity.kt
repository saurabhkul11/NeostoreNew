package com.example.neostorenew.view.activity.Login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.neostorenew.MainActivity
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityLoginBinding


class LoginActivity :BaseActivity<ActivityLoginBinding>() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun inflateLayout(layoutInflater: LayoutInflater)= ActivityLoginBinding.inflate(layoutInflater)
    override fun applyUI(lbinding: ActivityLoginBinding) {
        binding=lbinding
    }


}