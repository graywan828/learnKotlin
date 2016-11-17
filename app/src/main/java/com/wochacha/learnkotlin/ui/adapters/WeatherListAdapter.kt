package com.wochacha.learnkotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.wochacha.learnkotlin.R
import com.wochacha.learnkotlin.domain.model.Weather
import kotlinx.android.synthetic.main.item_rv_weather.view.*

/**
 * Created by guanghui_wan on 2016/11/16.
 */
class WeatherListAdapter(val items:List<Weather>)
    : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_weather,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindWeather(weather : Weather){
            Glide.with(itemView.context).load(weather.weather_icon).into(itemView.ivIconFrom)
            Glide.with(itemView.context).load(weather.weather_icon1).into(itemView.ivIconTo)

        }
    }

}