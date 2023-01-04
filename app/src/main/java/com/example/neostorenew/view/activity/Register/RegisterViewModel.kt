package com.example.neostorenew.view.activity.Register

import android.content.Context
import android.util.Patterns
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neostorenew.data.request.RegisterRequest
import com.example.neostorenew.data.response.RegisterResponse
import com.example.neostorenew.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private var registerRepository: RegisterRepository):ViewModel() {

    var registerdata = MutableLiveData<RegisterResponse>()
    // var errorlist=MutableLiveData<String>()


//    fun create(user:RegisterRequest){
//       viewModelScope.launch {
//           val result=registerRepository.createuser(user)
//           registerdata.postValue(result.body())
//
//       }
//}

    fun create(
        first_name:String,last_name:String,email:String,
        password:String,confirm_password:String,gender:String,phone_no:Long
    )
    {
        viewModelScope.launch {
            val result=registerRepository.createuser(
                first_name, last_name, email, password, confirm_password, gender, phone_no
            )
            registerdata.postValue(result.body())
        }


    }

    fun validcheck(
        first_name: String,
        last_name: String,
        email: String,
        register_password: String,
        confirm_password: String,
        group: RadioGroup,
        phone_no: String
    ) :Boolean{
        if (firstnamecheck(first_name) && lastnamecheck(last_name) && emailcheck(email) && password(
                register_password,
                confirm_password
            ) && gendercheck(group) && phonenocheck(phone_no)
        ){
            return true

        }
        return false
        error("Field are empty")
    }

    fun firstnamecheck(first_name: String): Boolean {
        if (first_name == null) {
            return false
            error("First Name is empty")
        }
        return true
    }

    fun lastnamecheck(last_name: String): Boolean {
        if (last_name == null) {
            return false
            error("Last Name is empty")
        }
        return true
    }

    fun password(register_password: String, confirm_password: String): Boolean {
        if (register_password!=null &&  confirm_password!=null) {
            if (register_password.length>=8 && confirm_password.length>=8 && (register_password==confirm_password)){
                return true
            }
            else{
                error("Length short")
            }
        }
        error("empty field")
        return false
    }
    fun emailcheck(email: String): Boolean {
        if (email == null) {
            return false
            error("Email is empty")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false
            error("Email pattern not match")
        }
        return true
    }

    fun phonenocheck(phone_no: String): Boolean {
        if (phone_no == null) {
            return false
            error("Phone Number is empty")
        } else if (phone_no.length != 10) {
            return false
            error("invalid number")
        }
        return true
    }

    fun gendercheck(radioButton: RadioGroup): Boolean {
        if (radioButton.checkedRadioButtonId==-1) {
            return false
        }
        return true
    }




}