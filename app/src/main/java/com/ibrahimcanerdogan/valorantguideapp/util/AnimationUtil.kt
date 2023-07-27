package com.ibrahimcanerdogan.valorantguideapp.util

import android.widget.ImageView

object AnimationUtil {

    fun animateArrow(imageView: ImageView) {
        val isDown = imageView.rotation == 90f
        if (isDown) imageView.animate().rotation(0f).start()
        else imageView.animate().rotation(90f).start()
    }
}