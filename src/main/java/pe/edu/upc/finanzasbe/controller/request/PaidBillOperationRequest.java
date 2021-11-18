package pe.edu.upc.finanzasbe.controller.request;

import java.math.BigDecimal;

public class PaidBillOperationRequest {

    String company;
    String ruc;
    BigDecimal value;
    Integer days;
    Float tep;
    Float d;
    Float netWorth;
    BigDecimal valueYouGet;
    Float tcea;
    Long userId;

    public Long getUserId() { return userId; }

    public String getCompany() { return company; }

    public String getRuc() { return ruc; }

    public BigDecimal getValue() { return value; }

    public Integer getDays() { return days; }

    public Float getTep() { return tep; }

    public Float getD() { return d; }

    public Float getNetWorth() { return netWorth; }

    public BigDecimal getValueYouGet() { return valueYouGet; }

    public Float getTcea() { return tcea; }
}
