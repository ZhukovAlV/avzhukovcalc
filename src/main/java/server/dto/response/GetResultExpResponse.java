package server.dto.response;

public class GetResultExpResponse {

    String dateExp;
    public String getDateExp() {
        return dateExp;
    }
    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    String dataExp;
    public String getDataExp() {
        return dataExp;
    }
    public void setDataExp(String dataExp) {
        this.dataExp = dataExp;
    }

    String resultExp;
    public String getResultExp() {
        return resultExp;
    }
    public void setResultExp(String resultExp) {
        this.resultExp = resultExp;
    }

    public GetResultExpResponse(String dateExp, String dataExp, String resultExp) {
        this.dateExp = dateExp;
        this.dataExp = dataExp;
        this.resultExp = resultExp;
    }
}
