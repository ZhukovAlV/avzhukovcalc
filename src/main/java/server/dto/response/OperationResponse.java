package server.dto.response;

public class OperationResponse {
    private String operation;
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public void setOperation(int operation) {
        this.operation = Integer.toString(operation);
    }
}
