package com.foo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NestedMap {
    
    public static void main(String[] args) {
        Map<String, Object> myMap = new HashMap<>();
        Map<String, Object> subMap1 = new HashMap<>();
        subMap1.put("s1k1", "s1v1");
        subMap1.put("s1k2", "s1v2");
        myMap.put("k1", subMap1);
        Map<String, Object> subMap2 = new HashMap<>();
        subMap2.put("s2k2", "s2v2");
        myMap.put("k2", subMap2);
        Map<String, Object> subMap3 = new HashMap<>();
        Map<String, Object> map4 = new HashMap<>();        
        map4.put("s4k4", "s4v4");
        subMap3.put("s3k3", map4);
        myMap.put("k3", subMap3);
        System.out.println(getNestedValue(myMap, null, "k3", "s3k3", "s4k4").toString());
        System.out.println(myMap.entrySet()
                                .stream()
                                .filter(entry -> entry.getKey().equals("k1"))
                                .flatMap(entry -> ((Map)entry.getValue()).entrySet().stream())
                                .filter(entry -> ((Entry<String, Object>) entry).getKey().equals("s1k1"))
                                .map(entry -> ((Entry<String, Object>) entry).getValue())
                                .collect(Collectors.toList()));
        System.out.println(getNestedValueUsingLambdas(myMap, "k3", "s3k3", "s4k4"));
    }
    
    public static Object getNestedValueUsingLambdas(Map<String, Object> data, String... keyPath) {

        String[] path = Arrays.copyOfRange(keyPath, 0, (keyPath.length - 1));
        String lastKey = keyPath[keyPath.length - 1];
        for (String key: path) {
            data = data.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(key))
                .flatMap(entry -> ((Map)entry.getValue()).entrySet().stream())
                .collect(Collectors.toMap(entry -> ((Entry<String, Object>) entry).getKey(), 
                                          entry -> ((Entry<String, Object>) entry).getValue()));
        }
        return data.get(lastKey);
    }

    public static Map<String, Object> getNestedMap(Map<String, Object> data, String... keyPath) {

        if (keyPath == null || keyPath.length == 0) {
            return data;
        }

        Map<String, Object> subMap = data;
        for (String key : keyPath) {
            if (subMap.containsKey(key)) {
                subMap = (Map) subMap.get(key);
            } else {
                return null;
            }
        }

        return subMap;
    }

    public static <T> T getNestedValue(Map<String, Object> data, Class<T> clazz, String... keyPath) {

        String[] path = Arrays.copyOfRange(keyPath, 0, (keyPath.length - 1));
        String lastKey = keyPath[keyPath.length - 1];
        Map<String, Object> nested = getNestedMap(data, path);
        return (T) nested.get(lastKey);
    }

}
