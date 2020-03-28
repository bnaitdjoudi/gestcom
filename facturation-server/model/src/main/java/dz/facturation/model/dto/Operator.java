package dz.facturation.model.dto;

public enum Operator {
    EQUAL("equal"), NEGAT("negat"), GREATER("greater"), LESS("less"), LIKE("like"), IN("in");

    private String operator;
    Operator(String operator){
        this.operator=operator;
    }

}
