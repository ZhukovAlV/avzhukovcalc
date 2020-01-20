package server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.service.ExpressionService;

import java.io.IOException;

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
    public RestResponse calculator (String param) {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultExpression(param));
        return result;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse count (String param) {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultCount(param));
        return result;
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse operation (String param) {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOperation(param));
        return result;
    }

    @RequestMapping(value = "/ondate", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse ondate (String param) {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOndate(param));
        return result;
    }

    @RequestMapping(value = "/onoperation", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse onoperation (String param) {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultOnoperation(param));
        return result;
    }

    @RequestMapping(value = "/popular", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse popular () {
        RestResponse result = new RestResponse();
        result.setParam(ExpressionService.resultPopular());
        return result;
    }
}
