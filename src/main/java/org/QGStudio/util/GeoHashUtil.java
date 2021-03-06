package org.QGStudio.util;

import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import org.QGStudio.model.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.List;

/**
 * @ClassName GeoHashUtil
 * @Description TODO
 * @Author huange7
 * @Date 2019-08-08 21:03
 * @Version 1.0
 */
public class GeoHashUtil {


        // 经纬度改变的长度大小
        private static final double LENGTH = 0.0216216216;

        public static String[] findNeighborGeohash(Location location){
            GeoHash center = GeoHash.withCharacterPrecision(location.getLatitude(), location.getLongitude(), 5);
            GeoHash top = center.getNorthernNeighbour();
            GeoHash bottom = center.getSouthernNeighbour();
            GeoHash left = center.getWesternNeighbour();
            GeoHash right = center.getEasternNeighbour();
            GeoHash topLeft = top.getWesternNeighbour();
            GeoHash topRight = top.getEasternNeighbour();
            GeoHash bottomLeft = bottom.getWesternNeighbour();
            GeoHash bottomRight = bottom.getEasternNeighbour();
            return new String[]{center.toString(),top.toString(),bottom.toString(),left.toString(),right.toString(),topLeft.toString(),topRight.toString()
            ,bottomLeft.toString(),bottomRight.toString()};
        }

        public static Location geohash2Location(String geohash){
            WGS84Point wgs84Point = GeoHash.fromGeohashString(geohash).getPoint();
            Location location = new Location();
            location.setLatitude(wgs84Point.getLatitude());
            location.setLongitude(wgs84Point.getLongitude());
            return location;
        }
}
