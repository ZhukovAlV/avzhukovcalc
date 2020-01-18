package server.exception;

public class CalculatorException extends Exception{
    private ErrorCode error;
    private String message;

    public CalculatorException(ErrorCode error) {
        super();
        this.error = error;
        this.message = error.getErrorString();
    }

    public ErrorCode getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
