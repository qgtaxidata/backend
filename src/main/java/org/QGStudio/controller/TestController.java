package org.QGStudio.controller;

import org.QGStudio.dtos.ResultBean;
import org.QGStudio.model.User;
import org.QGStudio.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @Autowired
    private TestService testService;

    @RequestMapping("/testUser")
    public ResultBean<?> testUser(@RequestParam int userId){

        return new ResultBean<>(testService.testUser(userId));
    }
}
