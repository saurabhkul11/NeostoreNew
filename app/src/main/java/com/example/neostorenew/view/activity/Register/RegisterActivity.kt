package com.example.neostorenew.view.activity.Register

import android.os.Bundle
import android.view.LayoutInflater
import com.example.neostorenew.R
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.databinding.ActivityRegistrationBinding

class RegisterActivity:BaseActivity<ActivityRegistrationBinding>() {

//   lateinit var binding: ActivityRegistrationBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding.btnRegisterButton.setOnClickListener {
//            setData()
//        }
//    }



    override fun inflateLayout(layoutInflater: LayoutInflater)=ActivityRegistrationBinding.inflate(layoutInflater)

    fun setData(binding: ActivityRegistrationBinding){

        var selectgender:String?=null
        val firstname=binding.txtInputFirstName.text.toString().trim()
        val lastname=binding.txtInputLastName.text.toString().trim()
        val email=binding.txtInputEmail.text.toString().trim()
        val phone=binding.txtInputPhoneNumber.text.toString()
        val confirmPassword=binding.txtInputConfirmedPassword.text.toString()
        val registerPassword=binding.txtInputRegPassword.text.toString()
        val radiobtn= binding.radioGroupButton
        when(radiobtn.id){
            R.id.radioBtnFemale->selectgender="F"
            R.id.radioBtnMale->selectgender="M"

        }

    }
}