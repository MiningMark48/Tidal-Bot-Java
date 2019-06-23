package com.miningmark48.tidalbot.util;

import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import net.dv8tion.jda.api.Permission;

import java.net.URL;
import java.util.*;

public class UtilData {

    public static final String SEPERATOR = System.lineSeparator();

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue (Map<K, V> map, boolean invert) {

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry<K,V>::getValue));

        if (invert)
            list = Lists.reverse(list);

        final Map<K, V> result = new LinkedHashMap<>();
        for (final Map.Entry<K, V> entry : list)
            result.put(entry.getKey(), entry.getValue());
        return result;
    }

    /* Returns true if url is valid */
    public static boolean isValidURL(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String toPermCSV(Permission[] data) {
        String result = "";
        if (data.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (Permission query : data) {
                builder.append(query.getName()).append(",");
            }
            result = builder.deleteCharAt(builder.length() - 1).toString();
        }
        return result;
    }

}
