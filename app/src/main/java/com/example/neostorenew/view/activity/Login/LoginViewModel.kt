package com.example.neostorenew.view.activity.Login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neostorenew.data.response.RegisterResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private var loginRepository: LoginRepository):ViewModel() {

    var logindata=MutableLiveData<RegisterResponse>()


    fun login(email:String,password:String){
        viewModelScope.launch {
            val result=loginRepository.loginuser(email, password)
            logindata.postValue(result.body())
        }
  }
    fun logincheck(username:String,password: String):Boolean{
        if (!usernamecheck(username) or !passwordcheck(password)){
            return false
        }
        return true
    }


    fun usernamecheck(username:String):Boolean{
        if (username==null){
            return false
        }
        return true
    }
    fun passwordcheck(password: String):Boolean{
        if (password==null){
            return false
        }
        return true
    }
}