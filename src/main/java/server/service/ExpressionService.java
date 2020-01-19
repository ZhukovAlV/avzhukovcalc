package server.service;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import server.dto.request.AddExpression;

public class ExpressionService {

    public static String resultExpression (AddExpression expr) {
        // spel
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expr.getExpression());
        return expression.getValue().toString();
    }
}
