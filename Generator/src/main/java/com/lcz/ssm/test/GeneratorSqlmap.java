package com.lcz.ssm.test;

import com.mysql.jdbc.Driver;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {
    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("D:\\myworkspace\\ideaspacework\\javaweb_ssm\\Generator\\src\\main\\resources\\generatorConfig.xml");

        org.mybatis.generator.config.xml.ConfigurationParser cp = new org.mybatis.generator.config.xml.ConfigurationParser(warnings);
        org.mybatis.generator.config.Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void jdbctest(){
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/";
            Connection connection = DriverManager.getConnection(url, "root", "123456");
            //获取预处理对象
            PreparedStatement statement = connection.prepareStatement("select from * user");
            //执行操作，获取结果集
            ResultSet resultSet = statement.executeQuery();
            //遍历结果集
            while (resultSet.next()){
                System.out.println(resultSet.getString("username"));
            }

            //释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
