package com.wochacha.learnkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_simple_test.*

class SimpleTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_test)

        message.text = "hello Kotlin"


        toast.setOnClickListener {
        //showToast("kotlin toast")
            showToast(msg = "kotlin toast",time = Toast.LENGTH_LONG)
        }

    }


    fun add(x:Int,y:Int):Int{
        return x + y
    }


    fun showToast(msg:String,
                  tag:String = javaClass.simpleName,
                  time:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this,"$msg  $tag",time).show()
    }
}
