package com.example.neostorenew.view.activity.Register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.neostorenew.MainActivity
import com.example.neostorenew.R
import com.example.neostorenew.base.BaseActivity
import com.example.neostorenew.data.request.RegisterRequest
import com.example.neostorenew.databinding.ActivityRegistrationBinding
import com.example.neostorenew.di.DaggerApplication
import com.example.neostorenew.utils.Constant.Constants
//import com.example.neostorenew.utils.SharedPrefFile
import com.example.neostorenew.utils.validation
import com.example.neostorenew.view.activity.Login.LoginActivity
import com.example.neostorenew.view.activity.Login.LoginViewModel
import javax.inject.Inject

class RegisterActivity : BaseActivity<ActivityRegistrationBinding>() {

    lateinit var binding: ActivityRegistrationBinding

    @Inject
    lateinit var viewModel: RegisterViewModel

//    @Inject
//    lateinit var sharedPrefFile: SharedPrefFile

    @Inject
    lateinit var registerviewmodelFactory: RegisterViewmodelFactory
    var selectgender: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as DaggerApplication).appcomponent.inject(this)

        binding.btnRegisterButton.setOnClickListener {
            setData()
        }
        viewModel =
            ViewModelProvider(this, registerviewmodelFactory).get(RegisterViewModel::class.java)
        viewModel.registerdata.observe(this, Observer {
            if (it?.status == 200) {
                showToast(it.message)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showToast(it.message)
            }
        })


    }

    override fun applyUI(rbinding: ActivityRegistrationBinding) {
        binding = rbinding
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityRegistrationBinding.inflate(layoutInflater)

    fun setData() {

        val firstname = binding.txtInputFirstName.text.toString().trim()
        val lastname = binding.txtInputLastName.text.toString().trim()
        val email = binding.txtInputEmail.text.toString().trim()
        val phone = binding.txtInputPhoneNumber.text.toString()
        val confirmPassword = binding.txtInputConfirmedPassword.text.toString()
        val registerPassword = binding.txtInputRegPassword.text.toString()
        val radiobtn = binding.radioGroupButton.checkedRadioButtonId
        when (radiobtn) {
            R.id.radioBtnFemale -> selectgender = "F"
            R.id.radioBtnMale -> selectgender = "M"

        }
        if (viewModel.validcheck(
                firstname,
                lastname,
                email,
                registerPassword,
                confirmPassword,
                binding.radioGroupButton,
                phone
            )
        ) {
            viewModel.create(
                firstname,
                lastname,
                email,
                registerPassword,
                confirmPassword,
                selectgender!!,
                phone.toLong()
            )

        }
    }


}