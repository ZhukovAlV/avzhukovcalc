package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.dao.CalculatorDAO;
import server.exception.CalculatorException;
import server.service.ExpressionService;

import java.text.ParseException;

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
    private RestResponse result = new RestResponse();
    public RestResponse getResult() {
        return result;
    }

    private final ExpressionService expressionService;

    @Autowired
    public Controller(ExpressionService expressionService) {
        this.expressionService = expressionService;
    }

    @Autowired
    private CalculatorDAO calculatorDAO;
    public CalculatorDAO getCalculatorDAO() {
        return calculatorDAO;
    }

    @GetMapping(value = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse calculator (String param) throws CalculatorException {
        getResult().setParam(ExpressionService.resultExpression(param,getCalculatorDAO()));
        return getResult();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse count (String param) throws CalculatorException, ParseException {
        getResult().setParam(ExpressionService.resultCount(param,getCalculatorDAO()));
        return getResult();
    }

    @GetMapping(value = "/operation", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse operation (String param) throws CalculatorException {
        getResult().setParam(ExpressionService.resultOperation(param,getCalculatorDAO()));
        return getResult();
    }

    @GetMapping(value = "/ondate", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse ondate (String param) throws CalculatorException, ParseException {
        getResult().setParam(ExpressionService.resultOndate(param,getCalculatorDAO()));
        return getResult();
    }

    @GetMapping(value = "/onoperation", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse onoperation (String param) throws CalculatorException {
        getResult().setParam(ExpressionService.resultOnoperation(param,getCalculatorDAO()));
        return getResult();
    }

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse popular () {
        getResult().setParam(ExpressionService.resultPopular(getCalculatorDAO()));
        return getResult();
    }

}
