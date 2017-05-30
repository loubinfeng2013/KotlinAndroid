package com.loubinfeng.www.kotlinandroid.mvc

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.loubinfeng.www.kotlinandroid.R
import com.loubinfeng.www.kotlinandroid.model.IUserModel
import com.loubinfeng.www.kotlinandroid.model.UserModel

class MvcActivity : AppCompatActivity() {

    private val username : EditText by lazy { findViewById(R.id.username) as EditText }
    private val password : EditText by lazy { findViewById(R.id.passowrd) as EditText }
    private val loginBtn : Button   by lazy { findViewById(R.id.login) as Button}
    private var userModel : IUserModel ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)
        userModel = UserModel{resultCode: Int ->
            if (resultCode == 20000){
                Log.i("info","MvcActivity-success")
                toast("success")
            }else{
                Log.i("info","MvcActivity-fail")
                toast("fail")
            }
        }
        addListener()
    }

    fun addListener() : Unit{
         loginBtn.setOnClickListener {
             var usernameString = username?.text?.toString()
             var passwordString = password?.text?.toString()
             userModel?.userLogin(usernameString,passwordString)
         }
    }

    fun Activity.toast(text : CharSequence?){
        runOnUiThread { Toast.makeText(this,text,Toast.LENGTH_SHORT) }
    }
}

