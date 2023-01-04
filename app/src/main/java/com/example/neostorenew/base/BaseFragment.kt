package com.example.neostorenew.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.R
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB:ViewBinding>:Fragment(){


    var binding:VB?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=getView(view)
    }

    abstract fun getView(view: View):VB
}

