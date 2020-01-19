package server.controller;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.dto.request.AddExpression;
import server.dto.response.GetResultExpression;
import server.service.ExpressionService;

@RestController
public class Controller {
    public static class RestResponse {
        private String param;
        public String getParam() {
            return param;
        }
        public void setParam(String param) {
            this.param = param;
        }

    }
    @RequestMapping(value = "/calculator", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod (String param) {
        // Формируем dto запрос
        AddExpression reqExpression = new AddExpression();
        reqExpression.setExpression(param);
        // Формируем dto ответ
        GetResultExpression responseExpression = new GetResultExpression();
        responseExpression.setResultExp(ExpressionService.resultExpression(reqExpression));
        // и передаем в result
        RestResponse result = new RestResponse();
        result.setParam(responseExpression.getResultExp());
        return result;
    }
}
