package com.hao.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化和反序列化例子
 *
 * @author Administrator
 */
public class SerializeDemo {

    /**
     * 序列化
     *
     * @param value
     * @return
     * @throws Exception
     */
    public byte[] serialize(Serializable value) throws Exception {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            oos.flush();
            oos.close();
            return bos.toByteArray();
        } catch (Exception e) {
            throw new Exception("Error serializing object.  Cause: " + e, e);
        }
    }

    /**
     * 反序列化
     *
     * @param value
     * @return
     * @throws Exception
     */
    public Serializable deserialize(byte[] value) throws Exception {
        Serializable result;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(value);
            ObjectInputStream ois = new ObjectInputStream(bis);
            result = (Serializable) ois.readObject();
            ois.close();
        } catch (Exception e) {
            throw new Exception("Error deserializing object.  Cause: " + e, e);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("chenghao");
        user.setSex("男");

        SerializeDemo s = new SerializeDemo();

        //序列化
        byte[] b = s.serialize(user);
        for (byte result : b) {
            System.out.println(result);
        }
        //反序列化
        User u = (User) s.deserialize(b);
        System.out.println(u.getName() + "--" + u.getSex());

    }
}

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}