package server.dto.request;

import java.util.Date;

public class CountRequest {
    private Date count;
    public Date getCount() {
        return count;
    }
    public void setCount(Date count) {
        this.count = count;
    }
}
