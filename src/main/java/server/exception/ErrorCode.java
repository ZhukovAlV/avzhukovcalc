package server.exception;

public enum ErrorCode {
    EXPRESSION_IS_WRONG("{\"error\" : \"Expression is not valid.\"}");

    private String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String getErrorString(){
        return message;
    }
}
