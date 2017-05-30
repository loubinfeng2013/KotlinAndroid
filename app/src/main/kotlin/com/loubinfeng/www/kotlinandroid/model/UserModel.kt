package com.loubinfeng.www.kotlinandroid.model

import android.util.Log
import kotlin.concurrent.thread

/**
 * Created by Administrator on 2017/5/30.
 */
class UserModel(private val callBack : (resultCode : Int)->Unit?) : IUserModel{

    override fun userLogin(username: String?, password: String?) {
        if (username == null || password == null) {
            callBack?.invoke(-1)
            return
        }
        thread{
            Log.i("info","thread start")
            Thread.sleep(2000)
            callBack?.invoke(20000)
            Log.i("info","thread end")
        }
    }
}