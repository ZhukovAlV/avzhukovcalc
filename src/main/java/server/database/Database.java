package server.database;

import java.util.*;

public class Database {
    private static Set<List<String>> result = new HashSet<>();

    public static Set<List<String>> getResult() {
        return result;
    }

    public static void setResult(Set<List<String>> result) {
        Database.result = result;
    }
}
