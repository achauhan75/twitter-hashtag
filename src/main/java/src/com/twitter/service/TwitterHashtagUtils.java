package src.com.twitter.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Util class
 */
public final class TwitterHashtagUtils {

    private TwitterHashtagUtils() {
    }

    /**
     * Helper function to sort hashmap by values first and if duplicate values found then sort keys lexicographical
     * @param map
     * @return
     */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        // Sort the list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer >a, Map.Entry<String, Integer>b) {
                if (a.getValue() < b.getValue()) { // Descending values
                    return 1;
                } else if (a.getValue() > b.getValue()) {
                    return -1;
                }
                return a.getKey().compareTo(b.getKey()); // Ascending keys
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> element : list) {
            temp.put(element.getKey(), element.getValue());
        }
        return temp;
    }
}
