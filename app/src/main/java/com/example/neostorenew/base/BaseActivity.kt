package com.example.neostorenew.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateLayout(layoutInflater)
        setContentView(binding.root)
        applyUI(binding)
    }

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    open fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    abstract fun applyUI(binding: VB)


}
