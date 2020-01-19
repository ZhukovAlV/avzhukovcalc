package server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.dao.ResultExpressionDao;
import server.daoimpl.ResultExpressionDaoImpl;
import server.database.Database;
import server.dto.request.AddExpression;
import server.dto.response.GetResultExpression;
import server.service.ExpressionService;

import java.util.Date;

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
        // Записываем результат в базу
        ResultExpressionDao resultExpressionDao = new ResultExpressionDaoImpl();
        resultExpressionDao.insert(new Date().toString(),param,responseExpression.getResultExp());
        // Передаем в result
        RestResponse result = new RestResponse();
        result.setParam(responseExpression.getResultExp());
        return result;
    }
}
