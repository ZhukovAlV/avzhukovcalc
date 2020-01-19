package server.service;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import server.dto.request.AddExpression;
import server.dto.response.GetResultExpression;

public class ExpressionService {

/*    private String param;
    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }

    public ExpressionService(String param) {
        this.param = param;
    }*/

    public static String resultExpression (AddExpression expr) {
        // spel
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expr.getExpression());
        return expression.getValue().toString();
    }
}
