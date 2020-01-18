package server.exception;

public enum ErrorCode {
    EXPRESSION_IS_WRONG("{\"error\" : \"Выражение содержит некорректные данные.\"}");

    private String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String getErrorString(){
        return message;
    }
}
