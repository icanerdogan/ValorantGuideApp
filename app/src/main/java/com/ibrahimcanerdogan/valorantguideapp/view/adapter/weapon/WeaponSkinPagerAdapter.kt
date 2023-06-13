package com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin.WeaponSkin

class WeaponSkinPagerAdapter(
    private val context: Context,
    private val skinList: List<WeaponSkin>
) : PagerAdapter() {

    override fun getCount(): Int {
        return skinList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_weapon_skin, container, false)
        val imageView = view.findViewById<AppCompatImageView>(R.id.imageViewItemWeaponSkin)
        val webView = view.findViewById<WebView>(R.id.webViewItemWeaponSkin)

        Glide.with(context)
            .load(skinList[position].skinDisplayIcon)
            .into(imageView)

        if (skinList[position].skinLevels[skinList[position].skinLevels.size - 1].levelStreamedVideo != null){
            webView.visibility = View.VISIBLE
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
            webView.loadUrl(skinList[position].skinLevels[skinList[position].skinLevels.size - 1].levelStreamedVideo!!)
        } else if (skinList[position].skinChromas[skinList[position].skinChromas.size - 1].chromaStreamedVideo != null) {
            webView.visibility = View.VISIBLE
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
            webView.loadUrl(skinList[position].skinChromas[skinList[position].skinChromas.size - 1].chromaStreamedVideo!!)
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}