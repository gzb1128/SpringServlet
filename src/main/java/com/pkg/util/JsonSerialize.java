package com.pkg.util;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonSerialize {
    public static byte[] Serialize(Object object) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteStream);
        oos.writeObject(object);
        return byteStream.toByteArray();
    }
    public static Object UnSerialize(byte[] byteArray) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
    public static Map<String, Object> MapObject(Object object){
        HashMap<String, Object> map = new HashMap<>();
        Class<?> cla = object.getClass();
        Field[] fields = cla.getDeclaredFields();
        Arrays.stream(fields).forEach((field)->{
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {}
            if (value == null) {
                value = "";
            }
            map.put(field.getName(), value);
        });
        return map;
    }
}
