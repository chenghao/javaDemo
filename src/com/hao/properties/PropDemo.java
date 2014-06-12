package com.hao.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropDemo {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();

        //文件输入流，
        //PropDemo.class.getResource("").getPath()是在当前类路经下，
        //PropDemo.class.getResource("/").getPath()是在classes根下
        FileInputStream fis = new FileInputStream(PropDemo.class.getResource("").getPath() + File.separator + "prop.properties");
        prop.load(fis);
        fis.close();

        System.out.println("获取属性值：name= " + prop.getProperty("name"));
        System.out.println("获取属性值：sex= " + prop.getProperty("sex", "男"));
        System.out.println("获取属性值：age= " + prop.getProperty("age"));

        prop.setProperty("wife", "钟丽娟");
        //获取当前工作目录 + / + prop.properties的src下面的路经
        String currentPath = System.getProperty("user.dir") + File.separator + "src/com/hao/properties/prop.properties";
        FileOutputStream fos = new FileOutputStream(currentPath);
        prop.store(fos, "添加老婆名称属性");
        System.out.println("添加成功。");
        fos.close();
    }

}
