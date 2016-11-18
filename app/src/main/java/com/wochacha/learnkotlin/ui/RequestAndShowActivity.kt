package com.wochacha.learnkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.wochacha.learnkotlin.R
import com.wochacha.learnkotlin.data.server.WeatherRequest
import com.wochacha.learnkotlin.domain.model.WeatherResult
import com.wochacha.learnkotlin.ui.adapters.WeatherListAdapter
import kotlinx.android.synthetic.main.activity_request_and_show.*
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class RequestAndShowActivity : AppCompatActivity() ,ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun enableHomeAsUp() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val context = this
    private val items = listOf<String>(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_and_show)

        initToolbar()

        rvWeather.layoutManager = LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        loadWeather()
    }

    private fun loadWeather() = async() {
        val weatherResult:WeatherResult = WeatherRequest("上海").execute()
        uiThread {
            rvWeather.adapter = WeatherListAdapter(weatherResult.result)
//                longToast("网络请求测试")
        }
    }
}
