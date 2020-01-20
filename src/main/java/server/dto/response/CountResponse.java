package server.dto.response;

public class CountResponse {
    private String count;
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public void setCount(int count) {
        this.count = Integer.toString(count);
    }
}
