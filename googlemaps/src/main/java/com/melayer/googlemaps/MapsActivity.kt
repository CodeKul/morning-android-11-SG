package com.melayer.googlemaps

import android.content.Context
import android.graphics.Color
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var locMgr : LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locMgr = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locMgr.requestLocationUpdates(
                LocationManager.PASSIVE_PROVIDER,
                1000,
                1f,
                LocLst()
        )
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMarkerClickListener {
            Toast
                    .makeText(this@MapsActivity, it.title, Toast.LENGTH_SHORT).show()

            true
        }

        // Add a marker in Sydney and move the camera
        val pune = LatLng(18.73, 72.56)
        val mumbai = LatLng(19.86, 78.9)

        mMap.addCircle(
                CircleOptions()
                        .center(pune)
                        .fillColor(Color.RED)
                        .strokeColor(Color.RED)
                        .strokeWidth(2f)
                        .radius(50.0)
        )

        val mrPn = mMap.addMarker(
                MarkerOptions()
                        .position(pune)
                        .title("Pune")
        )
        mrPn.isDraggable = true

        mMap.addMarker(
                MarkerOptions()
                        .position(mumbai)
                        .title("Mumbai")
        )

        mMap.addPolyline(
                PolylineOptions()
                        .add(pune, mumbai)
                        .width(2f)
                        .color(Color.RED)
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLng(pune))
    }

    inner class LocLst : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.i("@codekul", """ Location changed """)
            Log.i("@codekul", """ Lat - ${location.latitude} Lng - ${location.longitude} """)

            mMap.addMarker(
                    MarkerOptions()
                            .position(
                                    LatLng(location.latitude, location.longitude)
                            )
                            .title("Mumbai")
            )

        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }
    }
}
