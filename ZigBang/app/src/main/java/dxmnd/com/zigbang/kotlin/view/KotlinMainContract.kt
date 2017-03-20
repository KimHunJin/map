package dxmnd.com.zigbang.kotlin.view

import android.view.ViewGroup
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by HunJin on 2017-03-09.
 */

interface KotlinMainContract {
    interface View {
    }

    interface Presenter {
        val view: View
        var mapView: MapView
        var marker: MapPOIItem
        var mapPoint: MapPoint

        fun mapSetting(viewGroup: ViewGroup)

        fun marker(mapView: MapView, name: String, mapPoint: MapPoint)
    }
}