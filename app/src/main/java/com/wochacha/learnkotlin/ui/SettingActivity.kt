package com.wochacha.learnkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.antonioleiva.weatherapp.extensions.DelegatesExt
import com.wochacha.learnkotlin.R
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingActivity : AppCompatActivity() {

    companion object{
        val ZIP_CODE = "cityName"
        val DEFAULT_CITY_NAME = "上海"
    }

    var cityName: String by DelegatesExt.preference(this, ZIP_CODE, DEFAULT_CITY_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        etCityName.setText(cityName)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        cityName = etCityName.text.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        android.R.id.home -> {onBackPressed() ; true}
        else -> false
    }
}
