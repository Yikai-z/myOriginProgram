package com.example.simple.mybatis;

import com.example.simple.dao.IUserDao;
import com.example.simple.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yikai.zhang
 * @title: DaoTest
 * @projectName mybatisDemo
 * @description: TODO
 * @date 2020/12/3 16:40
 */
public class DaoTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader    = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    @Test
    public void test() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date birthday = sdf.parse("1990-03-01 18:30:00");
            IUserDao userDao = session.getMapper(IUserDao.class);
            //如果存在删除
            List<User> userList = userDao.selectUser();

            if(userList.size()>0){
                for(User user : userList) {
                    userDao.deleteUser(user);
                    session.commit();
                }
            }

            User user = new User();
            user.setUserName("mathyrs");
            user.setPassword("123");
            user.setBirthday(birthday);
            userDao.addUser(user);
            //插入操作必须提交
            session.commit();

            User user1 = userDao.selectUser().get(0);
            user1.setUserName("zhangsan");
            user1.setPassword("123456");
            user1.setBirthday(birthday);
            userDao.updateUser(user1);
            session.commit();
           // assertEquals(user1.getPassword(), user.getPassword());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
