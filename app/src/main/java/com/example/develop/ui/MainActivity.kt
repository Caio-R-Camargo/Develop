package com.example.develop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.develop.R
import com.example.develop.infra.DevelopConstants
import com.example.develop.infra.SecurityPreferences
import com.example.develop.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter : Int = DevelopConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)

        val name = mSecurityPreferences.getString(DevelopConstants.KEY.PERSON_NAME).toUpperCase()
        textName.text = "Bem vindo, $name!"

        imageAll.setColorFilter(resources.getColor(R.color.purple))
        handleNewPhrase()

        buttons()

    }

    fun buttons(){

        imageDev.setOnClickListener(){
            handleFilter(1)
        }

        imageAll.setOnClickListener(){
            handleFilter(2)
        }

        imageDay.setOnClickListener(){
            handleFilter(3)
        }

        buttonTip.setOnClickListener(){
            handleNewPhrase()
        }

    }

    private fun handleFilter(int: Int){

        imageDev.setColorFilter(resources.getColor(R.color.purple_black_variant))
        imageAll.setColorFilter(resources.getColor(R.color.purple_black_variant))
        imageDay.setColorFilter(resources.getColor(R.color.purple_black_variant))

        when(int){
            1 -> {
                imageDev.setColorFilter(resources.getColor(R.color.purple))
                mPhraseFilter = DevelopConstants.PHRASEFILTER.DEV
            }

            2 -> {
                imageAll.setColorFilter(resources.getColor(R.color.purple))
                mPhraseFilter = DevelopConstants.PHRASEFILTER.ALL
            }

            3 ->{
                imageDay.setColorFilter(resources.getColor(R.color.purple))
                mPhraseFilter = DevelopConstants.PHRASEFILTER.DAY
            }

        }

    }

    private fun handleNewPhrase(){

        textTips.text = Mock().getPhrase(mPhraseFilter)

    }

}