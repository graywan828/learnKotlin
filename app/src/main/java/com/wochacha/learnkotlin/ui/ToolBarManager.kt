package com.wochacha.learnkotlin.ui

import android.support.v7.widget.Toolbar
import com.wochacha.learnkotlin.R

/**
 * Created by guanghui_wan on 2016/11/17.
 */

interface ToolBarManager{

    val toolbar :Toolbar

    var toolbarTitle : String
        get() = toolbar.title.toString()
        set(value){
            toolbar.title = value
        }

    fun initToolbar(){
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
//                R.id.action_settings -> toolbar
            }
        }
    }
}