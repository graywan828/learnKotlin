package com.wochacha.learnkotlin.data.server

import com.google.gson.Gson
import com.wochacha.learnkotlin.domain.model.WeatherResult
import java.net.URL

/**
 * Created by guanghui_wan on 2016/11/17.
 */

class WeatherRequest(val weaId : String){
    companion object{
        private val WEATHER_URL = "http://api.k780.com:88/?" +
                "app=weather.future&appkey=15671&sign=2a181f48fd940d041cf2cabe262dd6ae&format=json&weaid="
    }

    fun execute(): WeatherResult {
        val weatherJsonStr = URL(WEATHER_URL+weaId).readText()
        return Gson().fromJson(weatherJsonStr, WeatherResult::class.java)
    }


}