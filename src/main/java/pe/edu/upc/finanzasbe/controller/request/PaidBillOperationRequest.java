package pe.edu.upc.finanzasbe.controller.request;

import java.math.BigDecimal;

public class PaidBillOperationRequest {

    String company;
    String ruc;
    BigDecimal value;
    Integer days;
    Integer tep;
    Integer d;
    Long netWorth;
    BigDecimal valueYouGet;
    Integer tcea;
    Long userId;

    public Long getUserId() { return userId; }

    public String getCompany() { return company; }

    public String getRuc() { return ruc; }

    public BigDecimal getValue() { return value; }

    public Integer getDays() { return days; }

    public Integer getTep() { return tep; }

    public Integer getD() { return d; }

    public Long getNetWorth() { return netWorth; }

    public BigDecimal getValueYouGet() { return valueYouGet; }

    public Integer getTcea() { return tcea; }
}
