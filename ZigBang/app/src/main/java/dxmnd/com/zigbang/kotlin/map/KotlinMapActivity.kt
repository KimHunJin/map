package dxmnd.com.zigbang.kotlin.map

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import dxmnd.com.zigbang.R
import dxmnd.com.zigbang.kotlin.view.KotlinMainContract
import dxmnd.com.zigbang.kotlin.view.KotlinMainPresenter
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class KotlinMapActivity : AppCompatActivity(), KotlinMainContract.View {

    private lateinit var presenter: KotlinMainPresenter
    private lateinit var mapPoint: MapPoint

    private val contentMap by lazy {
        findViewById(R.id.layout_content_map) as RelativeLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_map)

        presenter = KotlinMainPresenter().apply {
            view = this@KotlinMapActivity
            mapView = MapView(this@KotlinMapActivity)
            marker = MapPOIItem()
//            marker("name", mapPoint)
//            mapView.addPOIItem(marker)
//            mapPoint = MapPoint.mapPointWithGeoCoord(37.51139337574741,127.01835497289554)
        }
//        mapPoint = MapPoint.mapPointWithGeoCoord(37.51139337574741,127.01835497289554)
        mapPoint = MapPoint.mapPointWithGeoCoord(37.5113,127.0183)
        presenter.mapSetting(contentMap)
        presenter.marker(presenter.mapView,"name",mapPoint)

    }
}
