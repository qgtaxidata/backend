package org.QGStudio.service.impl;

import org.QGStudio.dao.TestDao;
import org.QGStudio.model.User;
import org.QGStudio.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @author: SheledonPeng
 * @Date: $
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao ;

    @Override
    public User testUser(int userId) {
        return testDao.testUser(userId);
    }
}
