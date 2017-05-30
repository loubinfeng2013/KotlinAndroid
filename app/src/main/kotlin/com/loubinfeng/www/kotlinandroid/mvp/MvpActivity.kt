package com.loubinfeng.www.kotlinandroid.mvp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.loubinfeng.www.kotlinandroid.Presentor.MvpPresentor
import com.loubinfeng.www.kotlinandroid.R
import com.loubinfeng.www.kotlinandroid.mvp.viewinterface.IMvpView

class MvpActivity : AppCompatActivity() , IMvpView {

    private val username : EditText by lazy { findViewById(R.id.username) as EditText }
    private val password : EditText by lazy { findViewById(R.id.passowrd) as EditText }
    private val loginBtn : Button   by lazy { findViewById(R.id.login) as Button }
    private var mPresentor : MvpPresentor ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        mPresentor = MvpPresentor(this,null)
        addListenr()
    }

    fun addListenr(){
        loginBtn.setOnClickListener { view -> mPresentor?.login(username?.text?.toString(),password?.text?.toString()) }
    }

    fun Activity.toast(text : CharSequence?){
        runOnUiThread { Toast.makeText(this,text, Toast.LENGTH_SHORT) }
    }

    /****************** IMvpView ********************/

    override fun loginSuccess() {
        Log.i("info","MvpActivity-success")
        toast("success")
    }

    override fun loginFail() {
        Log.i("info","MvpActivity-fail")
        toast("fail")
    }
}
