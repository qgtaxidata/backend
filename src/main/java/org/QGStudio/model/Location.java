package org.QGStudio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 单经纬度对象
 * @author < a href=" ">郭沛</ a>
 * @date 2019-08-08 19:37
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
