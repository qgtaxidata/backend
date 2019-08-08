package org.QGStudio.controller;

import org.QGStudio.dao.TestDao;
import org.QGStudio.dtos.ResultBean;
import org.QGStudio.model.Location;
import org.QGStudio.model.Point;
import org.QGStudio.model.User;
import org.QGStudio.service.TestService;
import org.QGStudio.util.GeoHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @author: SheledonPeng
 * @Date: $
 */

@RestController("/test")
@RequestMapping("/test")
public class TestController {

    // TODO 写实体类判断类
    @Autowired
    private TestService testService;

    @Autowired
    private TestDao testDao;

    @RequestMapping("/testUser")
    public ResultBean<?> testUser(@RequestParam int userId){

        return new ResultBean<>(testService.testUser(userId));
    }

    @RequestMapping("/test")
    public ResultBean<?> testFind(@RequestBody Location location, HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Headers",
                "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
        httpServletResponse.addHeader("Access-Control-Allow-Method","POST,GET");
        httpServletResponse.addHeader("Access-Control-Max-Age", "100");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials","true");
        String[] strings = GeoHashUtil.findNeighborGeohash(location);
        List<Location> locations = new LinkedList<>();
        for (String s :
                strings) {
            System.out.println(s);
            locations.addAll(testDao.findLocation(s.substring(s.lastIndexOf(" ")+1)+"%"));
        }
        Map<String ,Integer> map = new HashMap<>();
        for (Location location1: locations) {
            if(!map.containsKey(location1.getGeohash())){
                map.put(location1.getGeohash(),1);
            }else{
                map.put(location1.getGeohash(),map.get(location1.getGeohash())+1);
            }
        }
        List points = new LinkedList();
        Set<String> keys = map.keySet();
        for (String k:
             keys) {
            Point point =new Point();
            point.setCount(map.get(k));
            point.setLng(GeoHashUtil.geohash2Location(k).getLongitude());
            point.setLat(GeoHashUtil.geohash2Location(k).getLatitude());
            points.add(point);

            System.out.println(point.toString());
        }
        return new ResultBean<>(points);
    }
}
