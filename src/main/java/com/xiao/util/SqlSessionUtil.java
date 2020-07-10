package com.xiao.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author  XiaoHan
 * @date  2020/7/8 17:31
 * @version 1.0
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();
    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造对象私有化
     */
    private SqlSessionUtil() {
    }

    /**
     * 取得SQLSession
     * @return
     */
    public static SqlSession getSqlSession(){

        SqlSession sqlSession = t.get();
        if (sqlSession==null){
            sqlSession = factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myClose(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
            //这句必须加，非常容易忘
            t.remove();
        }
    }

}
