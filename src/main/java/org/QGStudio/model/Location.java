package org.QGStudio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Location
 * @Description TODO
 * @Author huange7
 * @Date 2019-08-08 21:07
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    // 经度
    private double longitude;
    // 纬度
    private double latitude;

    private String geohash;

    private int height;
}
