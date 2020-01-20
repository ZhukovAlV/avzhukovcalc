package server.dao;

import java.util.List;
import java.util.Set;

public interface ResultExpressionDao {
    void insert (String resultExpression,String expression,String dataExpression);
    Set<List<String>> getList ();
}
