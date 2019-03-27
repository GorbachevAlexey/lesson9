package ru.sbt.javaschool;

public class ReflectionsUtils {
    public static Class GetPrimitiveClass(final Class wrapperClass) {
        if (wrapperClass == Byte.class) return byte.class;
        if (wrapperClass == Short.class) return short.class;
        if (wrapperClass == Integer.class) return int.class;
        if (wrapperClass == Long.class) return long.class;
        if (wrapperClass == Float.class) return float.class;
        if (wrapperClass == Double.class) return double.class;

        return wrapperClass;
    }
}
