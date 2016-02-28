package hack.sport.sporthealthandroidapp;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlLayer;
import com.google.maps.android.kml.KmlPlacemark;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Abhishek Kumar on 2/27/2016.
 */
public class UserHeatGoogleMap extends MapsActivity {

    @Override
    protected void startDemo(GoogleMap googleMap) {
        try {
            KmlLayer layer = new KmlLayer(googleMap, R.raw.at_shelters_sym, getApplicationContext());
            layer.addLayerToMap();

            LatLng latLng = new LatLng(18.5176601,73.8539843);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    latLng, 15));

            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(latLng)
                    .zoom(15)
                    .bearing(90)
                    .build();

            // Animate the change in camera view over 2 seconds
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),2000, null);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
