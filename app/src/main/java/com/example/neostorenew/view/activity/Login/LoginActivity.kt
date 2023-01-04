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
import com.example.neostorenew.di.DaggerApplication
import com.example.neostorenew.utils.SharedPrefFile
import com.example.neostorenew.view.activity.Register.RegisterActivity
import com.example.neostorenew.view.activity.dashboard.DashBoardActivity
import javax.inject.Inject

class LoginActivity :BaseActivity<ActivityLoginBinding>() {

    lateinit var binding: ActivityLoginBinding
    @Inject
    lateinit var sharedPrefFile:SharedPrefFile
    @Inject
    lateinit var viewModel: LoginViewModel
    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as DaggerApplication).appcomponent.inject(this)

        viewModel=ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)

        viewModel.logindata.observe(this, Observer {
            if (it?.status==200){
                showToast("Successful")
                sharedPrefFile.saveToken(it.data.access_token)
                val intent = Intent(this, DashBoardActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                showToast("ERROR")
            }
        })

        binding.btnLoginButton.setOnClickListener {
           login()
        }
        binding.imgplusimage.setOnClickListener {
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    override fun inflateLayout(layoutInflater: LayoutInflater)= ActivityLoginBinding.inflate(layoutInflater)
    override fun applyUI(lbinding: ActivityLoginBinding) {
        binding=lbinding
    }

    fun login(){
        val username=binding.txtInputUserName.text.toString()
        val password=binding.txtInputPassword.text.toString()
        if (viewModel.logincheck(username, password)){
            viewModel.login(username,password)
        }
    }
}