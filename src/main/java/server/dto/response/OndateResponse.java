package server.dto.response;

import java.util.List;

public class OndateResponse {
    private List<String> ondate;
    public String getOndate() {
        return ondate.toString();
    }
    public void setOndate(List<String> ondate) {
        this.ondate = ondate;
    }
}
