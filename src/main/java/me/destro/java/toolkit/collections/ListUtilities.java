package me.destro.java.toolkit.collections;

import java.lang.reflect.Array;
import java.util.List;

public class ListUtilities {

    static public <T> T[] asArray(List<T> list, Class<T[]> clazz) {
        T[] array = clazz.cast(Array.newInstance(clazz.getComponentType(), list.size()));
        return list.toArray(array);
    }

}
