package com.example.develop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.develop.BuildConfig
import com.example.develop.R
import com.example.develop.infra.DevelopConstants
import com.example.develop.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class SplashActivity : AppCompatActivity() {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        versionName.setText("ver-" + BuildConfig.VERSION_NAME)

        mSecurityPreferences = SecurityPreferences(this)

        handleSave()
        nameValidation()

    }

    fun nameValidation(){

        if (mSecurityPreferences.getString(DevelopConstants.KEY.PERSON_NAME) != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    fun handleSave() {

        buttonSave.setOnClickListener() {
            val name = editName.text.toString()

            if (name != "") {
                mSecurityPreferences.storeString(DevelopConstants.KEY.PERSON_NAME, name)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                snackBarCustom()
            }

        }


    }

    fun snackBarCustom(){
        Snackbar.make(findViewById(android.R.id.content), "Preecha seu nome!",
                Snackbar.LENGTH_LONG).setAction("Action", null).setTextColor(
                resources.getColor(R.color.purple)).setAction("Ok", View.OnClickListener {}).setActionTextColor(
                resources.getColor(R.color.white)).show()
    }

}
