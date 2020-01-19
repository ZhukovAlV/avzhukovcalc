package server.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Map<String,List<String>> result = new HashMap<>();

    public static Map<String, List<String>> getResult() {
        return result;
    }

    public static void setResult(Map<String, List<String>> result) {
        Database.result = result;
    }
}
