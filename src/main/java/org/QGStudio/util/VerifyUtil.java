package org.QGStudio.util;

import java.util.Collection;

/**
 * @Description :
 * @Param :
 * @Return :
 * @Author : SheldonPeng
 * @Date : 2019-08-06
 */
public class VerifyUtil {


    /**
     * @Description : 判断字符串是否为空
     * @Param : [string]
     * @Return : boolean
     * @Author : SheldonPeng
     * @Date : 2019-08-06
     */

    public static boolean isEmpty(String string){

        return  (null == string  || "".equals(string) );
    }

    /**
     * @Description : 判断对象是否为空
     * @Param : [object]
     * @Return : boolean
     * @Author : SheldonPeng
     * @Date : 2019-08-07
     */
    public static boolean isNull(Object object){

        return null == object;
    }

    /**
     * @Description : 判断集合是否为空
     * @Param : [collection]
     * @Return : boolean
     * @Author : SheldonPeng
     * @Date : 2019-08-07
     */
    public static boolean isEmpty(Collection<?> collection){

        return  ( null == collection || collection.size() == 0 );
    }



}
