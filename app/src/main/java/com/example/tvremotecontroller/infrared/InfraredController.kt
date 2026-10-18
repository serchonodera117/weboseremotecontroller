package com.example.tvremotecontroller.infrared

import  android.content.Context
import android.hardware.ConsumerIrManager

class InfraredController(context: Context) {
    private  val irManager = context.getSystemService(Context.CONSUMER_IR_SERVICE)
    as? ConsumerIrManager


    fun isAvailable():Boolean {
        return  irManager?.hasIrEmitter() == true
    }


}