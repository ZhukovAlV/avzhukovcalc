package server.service;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;
import server.dao.ResultExpressionDao;
import server.daoimpl.ResultExpressionDaoImpl;
import server.dto.request.*;
import server.dto.response.*;
import server.exception.CalculatorException;
import server.exception.ErrorCode;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExpressionService {

/*    public static Date parseDate (String dateString) throws ParseException {
       // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(dateString);
        return date;
    }*/

    public static String resultExpression (String param, ResultExpressionDao resultExpressionDao) throws CalculatorException {
        if (!isCorrectExp(param)) throw new CalculatorException(ErrorCode.EXPRESSION_IS_WRONG);
        // Формируем dto запрос
        AddExpressionRequest reqExpression = new AddExpressionRequest();
        reqExpression.setExpression(param);
        // spel
        ExpressionParser parser = new SpelExpressionParser();
        Expression resultExpression = parser.parseExpression(reqExpression.getExpression());
        // Формируем dto ответ
        GetResultExpResponse responseExpression = new GetResultExpResponse(resultDate(),
                reqExpression.getExpression(),  Objects.requireNonNull(resultExpression.getValue()).toString());
        // Записываем результат в базу
        resultExpressionDao.insert(responseExpression.getDateExp(),responseExpression.getDataExp(),responseExpression.getResultExp());
        return responseExpression.getResultExp();
    }

    public static String resultDate () {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }

    public static String resultCount (String param, ResultExpressionDao resultExpressionDao) throws CalculatorException {
        if (!isCorrectExp(param)) throw new CalculatorException(ErrorCode.EXPRESSION_IS_WRONG);
        // Формируем dto запрос
        CountRequest countRequest = new CountRequest();
        countRequest.setCount(param);
        // Находим в базе записи на нужную дату
        int col=0;
        for (List<String> list : resultExpressionDao.getList()
             ) {
            if (list.get(0).equals(countRequest.getCount())) col+=1;
        }
        // Формируем dto ответ
        CountResponse countResponse = new CountResponse();
        countResponse.setCount(col);
        return countResponse.getCount();
    }

    public static String resultOperation (String param, ResultExpressionDao resultExpressionDao) throws CalculatorException {
        if (!isCorrectExp(param)) throw new CalculatorException(ErrorCode.EXPRESSION_IS_WRONG);
        // Формируем dto запрос
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setOperation(param);
        // Находим в базе записи на нужную дату
        int col=0;
        for (List<String> list : resultExpressionDao.getList()
        ) {
            if (list.get(1).contains(operationRequest.getOperation())) col+=1;
        }
        // Формируем dto ответ
        OperationResponse operationResponse = new OperationResponse();
        operationResponse.setOperation(col);
        return operationResponse.getOperation();
    }

    public static String resultOndate (String param, ResultExpressionDao resultExpressionDao) throws CalculatorException {
        if (!isCorrectExp(param)) throw new CalculatorException(ErrorCode.EXPRESSION_IS_WRONG);
        // Формируем dto запрос
        OndateRequest ondateRequest = new OndateRequest();
        ondateRequest.setOndate(param);
        // Находим в базе записи на нужную дату
        List<String> listRes = new ArrayList<>();
        for (List<String> list : resultExpressionDao.getList()
        ) {
            if (list.get(0).equals(ondateRequest.getOndate())) listRes.add(list.get(1));
        }
        // Формируем dto ответ
        OndateResponse ondateResponse = new OndateResponse();
        ondateResponse.setOndate(listRes);
        return ondateResponse.getOndate();
    }

    public static String resultOnoperation(String param, ResultExpressionDao resultExpressionDao) throws CalculatorException {
        if (!isCorrectExp(param)) throw new CalculatorException(ErrorCode.EXPRESSION_IS_WRONG);
        // Формируем dto запрос
        OnoperationRequest onoperationRequest = new OnoperationRequest();
        onoperationRequest.setOnoperation(param);
        // Находим в базе записи на нужную дату
        List<String> listRes = new ArrayList<>();
        for (List<String> list : resultExpressionDao.getList()
        ) {
            if (list.get(1).contains(onoperationRequest.getOnoperation())) listRes.add(list.get(1));
        }
        // Формируем dto ответ
        OnoperationResponse onoperationResponse = new OnoperationResponse();
        onoperationResponse.setOnoperation(listRes);
        return onoperationResponse.getOnoperation();
    }

    public static String resultPopular (ResultExpressionDao resultExpressionDao) {
        // Размещаем в Map число и сколько раз оно встречается
        Map<String,Integer> hm = new HashMap<>();
        for (String x:returnArray()){

            if (!hm.containsKey(x)){
                hm.put(x,1);
            } else {
                hm.put(x, hm.get(x)+1);
            }
        }
        // Формируем dto ответ
        PopularResponse popularResponse = new PopularResponse();
        popularResponse.setPopular(hm.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
        return popularResponse.getPopular();
    }

    public static List<String> returnArray () {
        ResultExpressionDao resultExpressionDao = new ResultExpressionDaoImpl();
        List<String> numbers = new ArrayList<>();
        for (List<String> list : resultExpressionDao.getList()
        ) {
            String[] parts = list.get(1).split("[^0-9]");
            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].equals("")) {
                    numbers.add(parts[i]);
                }
            }
        }
        return numbers;
    }

    private static boolean isCorrectExp(String str) {
        return str.matches("[\\d|\\+|\\-|\\/|\\*|\\^|\\(|\\)]*");
    }
}
