package server.dto.response;

import server.entity.Calculator;

import java.util.Date;

public class GetExpressionResponse {
    private Calculator calculator = new Calculator();
    public Calculator getCalculator() {
        return calculator;
    }

    public GetExpressionResponse(Date date, String expression, String result) {
        this.calculator.setDate(date);
        this.calculator.setExpression(expression);
        this.calculator.setResult(result);
    }

    public String getResult() {
        return  getCalculator().getResult();
    }
}
