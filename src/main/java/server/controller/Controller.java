package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.dao.ResultExpressionDao;
import server.daoimpl.ResultExpressionDaoImpl;
import server.exception.CalculatorException;
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

    private final ExpressionService expressionService;

    @Autowired
    public Controller(ExpressionService expressionService) {
        this.expressionService = expressionService;
    }

    private ResultExpressionDao resultExpressionDao = new ResultExpressionDaoImpl();
    public ResultExpressionDao getResultExpressionDao() {
        return resultExpressionDao;
    }
    public void setResultExpressionDao(ResultExpressionDao resultExpressionDao) {
        this.resultExpressionDao = resultExpressionDao;
    }

    @GetMapping(value = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse calculator (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultExpression(param,getResultExpressionDao()));
        return result;
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse count (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultCount(param,getResultExpressionDao()));
        return result;
    }

    @GetMapping(value = "/operation", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse operation (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOperation(param,getResultExpressionDao()));
        return result;
    }

    @GetMapping(value = "/ondate", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse ondate (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOndate(param,getResultExpressionDao()));
        return result;
    }

    @GetMapping(value = "/onoperation", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse onoperation (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOnoperation(param,getResultExpressionDao()));
        return result;
    }

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse popular () {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultPopular(getResultExpressionDao()));
        return result;
    }
}
