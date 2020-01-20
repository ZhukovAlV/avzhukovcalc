package server.dto.response;

import java.util.List;

public class OnoperationResponse {
    private List<String> onoperation;
    public String getOnoperation() {
        return onoperation.toString();
    }
    public void setOnoperation(List<String> onoperation) {
        this.onoperation = onoperation;
    }
}
