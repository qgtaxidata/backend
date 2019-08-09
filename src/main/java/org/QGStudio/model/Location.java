package org.QGStudio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    //经度
    private Double longitude;
    //纬度
    private Double latitude;
    // 时间
    private String time;
}
