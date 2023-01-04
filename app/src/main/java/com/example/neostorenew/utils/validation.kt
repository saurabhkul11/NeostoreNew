package com.example.neostorenew.utils

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.neostorenew.databinding.ActivityRegistrationBinding

object validation {



//    fun registervalid(context:Context,binding: ActivityRegistrationBinding):Boolean {
//        if(emptycheck(context,binding) && passwordcheck(context,binding) && phonenocheck(context,binding)){
//           return  true
//        }
//        else{
//            return false
//            Toast.makeText(context,"Registered not valid",Toast.LENGTH_SHORT).show()
//
//        }
//    }




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


    fun emptycheck(context: Context, binding: ActivityRegistrationBinding): Boolean {
        if (binding.txtInputFirstName.text.isEmpty() || binding.txtInputLastName.text.isEmpty()
            || binding.txtInputEmail.text.isEmpty() || binding.txtInputConfirmedPassword.text.isEmpty() ||
            binding.txtInputPhoneNumber.text.isEmpty() || binding.txtInputRegPassword.text.isEmpty() || (binding.radioGroupButton.checkedRadioButtonId == -1)
        ) {
            Toast.makeText(context, "Fill empty Fields", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    fun phonenocheck(context: Context, binding: ActivityRegistrationBinding): Boolean {
        if (binding.txtInputPhoneNumber.text.length == 10) {
            return true
        } else {
            Toast.makeText(context, "Provide valid mobile number", Toast.LENGTH_SHORT).show()
            return false
        }

    }

    fun passwordcheck(context: Context, binding: ActivityRegistrationBinding): Boolean {
        if (binding.txtInputRegPassword.text.toString() == binding.txtInputConfirmedPassword.text.toString()) {
            return true

        } else {
            Toast.makeText(context, "password not match", Toast.LENGTH_SHORT).show()
            return false
        }
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

