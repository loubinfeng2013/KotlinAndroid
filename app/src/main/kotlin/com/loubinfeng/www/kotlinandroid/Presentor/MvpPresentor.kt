package com.loubinfeng.www.kotlinandroid.Presentor

import com.loubinfeng.www.kotlinandroid.model.IUserModel
import com.loubinfeng.www.kotlinandroid.model.UserModel
import com.loubinfeng.www.kotlinandroid.mvp.viewinterface.IMvpView

/**
 * Created by Administrator on 2017/5/30.
 */
class MvpPresentor(private val mvpView : IMvpView,private var userModel : IUserModel?) {

    init {
        userModel = UserModel{resultCode: Int ->
            if (resultCode == 20000)
                mvpView.loginSuccess()
            else
                mvpView.loginFail()
        }
    }

    fun login(username : String?,password : String?){
        userModel?.userLogin(username,password)
    }

}