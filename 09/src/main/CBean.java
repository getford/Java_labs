package main;

public class CBean {
    String Value1 = null;
    String Value2 = null;
    String Value3 = null;
    String Value  = null;

    public String getValue1() {
        return Value1;
    }

    public void setValue1(String value1) {
        Value1 = value1;
    }

    public String getValue2() {
        return Value2;
    }

    public void setValue2(String value2) {
        Value2 = value2;
    }

    public String getValue3() {
        return Value3;
    }

    public void setValue3(String value3) {
        Value3 = value3;
    }

    public CBean(String value) {
        this.Value = value;
    }
    public CBean(){}

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String toString () {
        return (Value+";"+Value1+";"+Value2+";"+Value3);
    }

}
