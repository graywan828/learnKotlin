package com.wochacha.learnkotlin.domain.commands

/**
 * Created by guanghui_wan on 2016/11/16.
 */
public interface Command<T>{
    fun execute():T
}