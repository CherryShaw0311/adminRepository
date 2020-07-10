package com.xiao.util;
/**
 * @author  XiaoHan
 * @date  2020/7/8 18:09
 * @version 1.0
 */
public class ServiceFactory {
    //传递zs对象，得到ls对象的过程
    public static Object getService(Object service){

        return new TransactionInvacationHandler(service).getProxy();

    }
}
