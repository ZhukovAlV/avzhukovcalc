package server.controller;

import org.springframework.http.MediaType;
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

    private ResultExpressionDao resultExpressionDao = new ResultExpressionDaoImpl();
    public ResultExpressionDao getResultExpressionDao() {
        return resultExpressionDao;
    }
    public void setResultExpressionDao(ResultExpressionDao resultExpressionDao) {
        this.resultExpressionDao = resultExpressionDao;
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse calculator (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultExpression(param,getResultExpressionDao()));
        return result;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse count (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultCount(param,getResultExpressionDao()));
        return result;
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse operation (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOperation(param,getResultExpressionDao()));
        return result;
    }

    @RequestMapping(value = "/ondate", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse ondate (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOndate(param,getResultExpressionDao()));
        return result;
    }

    @RequestMapping(value = "/onoperation", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse onoperation (String param) throws CalculatorException {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOnoperation(param,getResultExpressionDao()));
        return result;
    }

    @RequestMapping(value = "/popular", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse popular () {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultPopular(getResultExpressionDao()));
        return result;
    }
}
