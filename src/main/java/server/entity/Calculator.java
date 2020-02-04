package server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Calculator {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String expression;

    @Temporal(TemporalType.DATE)
    @Column
    private Date date;

    @Column
    private Double result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
