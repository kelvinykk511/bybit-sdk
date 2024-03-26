package io.github.kelvinykk511.bybitsdk.util;

public class QueryStringUtil {

    public static <T> String generateQueryString(T obj) {
        StringBuilder queryStr = new StringBuilder();
        try {
            for (var field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(obj) != null) {
                    queryStr.append(field.getName()).append("=").append(field.get(obj)).append("&");
                }
            }
            // remove the last "&"
            queryStr.deleteCharAt(queryStr.length() - 1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return queryStr.toString();
    }
}
