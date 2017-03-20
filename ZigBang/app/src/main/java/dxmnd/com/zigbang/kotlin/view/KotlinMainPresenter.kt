package dxmnd.com.zigbang.kotlin.view

import android.view.ViewGroup
import dxmnd.com.zigbang.key.APIKey
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by HunJin on 2017-03-09.
 */

class KotlinMainPresenter : KotlinMainContract.Presenter {
    lateinit override var view: KotlinMainContract.View
    lateinit override var mapView: MapView
    lateinit override var marker: MapPOIItem
    lateinit override var mapPoint: MapPoint

    override fun mapSetting(viewGroup: ViewGroup) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mapView.setDaumMapApiKey(APIKey.API_KEY)
        viewGroup.addView(mapView)
    }

    override fun marker(mapView: MapView, name: String, mapPoint:MapPoint) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        marker.itemName = name
        marker.mapPoint = mapPoint
        marker.markerType = MapPOIItem.MarkerType.BluePin
        mapView.addPOIItem(marker)
    }
}
