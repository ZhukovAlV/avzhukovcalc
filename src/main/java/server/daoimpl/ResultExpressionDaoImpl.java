package server.daoimpl;

import server.dao.ResultExpressionDao;
import server.database.Database;

import java.util.ArrayList;
import java.util.List;

public class ResultExpressionDaoImpl implements ResultExpressionDao {

    @Override
    public void insert(String dataExpression, String expression, String resultExpression) {
        List<String> result = new ArrayList<>();
        result.add(dataExpression);
        result.add(expression);
        result.add(resultExpression);
        Database.getResult().add(result);
    }

}
