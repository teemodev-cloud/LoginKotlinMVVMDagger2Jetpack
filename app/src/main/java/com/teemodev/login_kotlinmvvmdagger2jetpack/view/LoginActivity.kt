package com.teemodev.login_kotlinmvvmdagger2jetpack.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.teemodev.login_kotlinmvvmdagger2jetpack.R
import com.teemodev.login_kotlinmvvmdagger2jetpack.data.local.entity.LoginEntity
import com.teemodev.login_kotlinmvvmdagger2jetpack.databinding.ActivityLoginBinding
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.base.BaseActivity
import com.teemodev.login_kotlinmvvmdagger2jetpack.presentation.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    lateinit var context: Context

    lateinit var strUsername: String
    lateinit var strPassword: String

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun onViewReady(savedInstance: Bundle?) {
        initView()
    }

    private fun initView() {
        context = this@LoginActivity

        btnLogin.setOnClickListener {

            strUsername = txtUsername.text.toString().trim()
            strPassword = txtPassword.text.toString().trim()

            if (strPassword.isEmpty()) {
                txtUsername.error = "Please enter the username"
            } else if (strPassword.isEmpty()) {
                txtPassword.error = "Please enter the username"
            } else {
                viewModel.login(strUsername, strPassword).observe(this, Observer {
                    if (it != null) {
                        viewModel.insertData(it.userId, it.userName)
                        Toast.makeText(context, "Login success!", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

        btnShowInfo.setOnClickListener {
            viewModel.getLoginDetails()!!.observe(this, Observer {
                if (it == null) {
                    Toast.makeText(
                        context,
                        "Data Not Found",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Info: ${it.userId} - ${it.userName}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}