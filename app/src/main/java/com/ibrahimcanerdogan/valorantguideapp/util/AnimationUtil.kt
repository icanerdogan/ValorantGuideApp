package com.ibrahimcanerdogan.valorantguideapp.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView

object AnimationUtil {

    fun animateArrow(imageView: ImageView) {
        val isDown = imageView.rotation == 90f
        if (isDown) imageView.animate().rotation(0f).start()
        else imageView.animate().rotation(90f).start()
    }

    fun flipAnimation(flipView: View, animView: View) {
        val animation1 = ObjectAnimator.ofFloat(flipView, "scaleX", 1f, 0f)
        val animation2 = ObjectAnimator.ofFloat(flipView, "scaleX", 0f, 1f)

        animation1.interpolator = DecelerateInterpolator()
        animation2.interpolator = AccelerateInterpolator()

        animation1.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                if (animView.visibility == View.INVISIBLE) animView.visibility = View.VISIBLE else animView.visibility = View.INVISIBLE
                animation2.start()
            }
        })
        animation1.start()
    }
}