package server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Calculator {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String expression;

    @Temporal(TemporalType.DATE)
    @Column
    private Date date;

    @Column
    private String result;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
