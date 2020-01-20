package server.dto.response;

public class PopularResponse {
    private String popular;
    public String getPopular() {
        return popular;
    }
    public void setPopular(String popular) {
        this.popular = popular;
    }
    public void setPopular(int popular) {
        this.popular = Integer.toString(popular);
    }
}
