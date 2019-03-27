package ru.sbt.javaschool;

import java.io.*;
import java.lang.reflect.Field;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class SerializableUtils {
    public static void serialize(Object obj, String fileName, boolean compressed) {
        File file = new File(fileName);
        ObjectOutputStream objectOutputStream = null;
        try {
            OutputStream outputStream = new FileOutputStream(file);
            if (compressed) outputStream = new DeflaterOutputStream(outputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static Object deserialize(final String fileName, final boolean compressed) {
        Object obj = null;
        File file = new File(fileName);
        ObjectInputStream objectInputStream = null;
        try {
            InputStream inputStream = new FileInputStream(file);
            if (compressed) inputStream = new InflaterInputStream(inputStream);
            objectInputStream = new ObjectInputStream(inputStream);
            obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return obj;
    }
}
