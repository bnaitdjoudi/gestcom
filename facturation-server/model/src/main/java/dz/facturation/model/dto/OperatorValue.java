package dz.facturation.model.dto;

import java.io.Serializable;

public class OperatorValue implements Serializable {

    private Operator operator;
    private Object value;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
