package com.loubinfeng.www.kotlinandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.loubinfeng.www.kotlinandroid.mvc.MvcActivity
import com.loubinfeng.www.kotlinandroid.mvp.MvpActivity
import com.loubinfeng.www.kotlinandroid.mvvm.MvvmActivity


class KotlinActivity : AppCompatActivity(),View.OnClickListener {

    private val mvcBtn  : Button by lazy { findViewById(R.id.mvc)  as Button }
    private val mvpBtn  : Button by lazy { findViewById(R.id.mvp)  as Button }
    private val mvvmBtn : Button by lazy { findViewById(R.id.mvvm) as Button }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        setListener()
    }

    fun setListener(){
        mvcBtn?.setOnClickListener(this)
        mvpBtn?.setOnClickListener(this)
        mvvmBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var target : Intent ?= when(v?.id){
            R.id.mvc  -> Intent(this,MvcActivity::class.java)
            R.id.mvp  -> Intent(this,MvpActivity::class.java)
            R.id.mvvm -> Intent(this,MvvmActivity::class.java)
            else      -> null
        }
        target?.let { startActivity(target) }
    }
}
