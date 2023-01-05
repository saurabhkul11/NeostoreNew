package com.example.neostorenew.view.activity.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.neostorenew.R
import com.example.neostorenew.databinding.ActivitySplashBinding
import com.example.neostorenew.view.activity.Login.LoginActivity
import com.example.neostorenew.view.activity.Register.RegisterActivity

class SplashActivity:AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var splashicon = binding.splashIcon
        splashicon.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
