package com.drakeapk.utilities

import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var cameraM :CameraManager
    private lateinit var powerBtn:ImageButton
    var isflash=false
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        powerBtn= findViewById(R.id.power)
        cameraM= getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerBtn.setOnClickListener{ flashLightONorOFF(it)}



    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun flashLightONorOFF(it: View?) {
        if(!isflash) {
            val cameraListId=cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isflash=true
            powerBtn.setImageResource(R.drawable.power_on)
        }
        else{
        val cameraListId=cameraM.cameraIdList[0]
        cameraM.setTorchMode(cameraListId,false)
        isflash=false
        powerBtn.setImageResource(R.drawable.power_off)


    }

    }
}