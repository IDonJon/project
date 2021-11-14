package pe.edu.upc.finanzasbe.controller.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillOperationRequest {

    String company;
    Integer dueTo;
    LocalDate emissionDate;
    LocalDate paidDate;
    String ruc;
    String status;
    Long userId;
    BigDecimal value;

    public String getCompany() {
        return company;
    }

    public Integer getDueTo() {
        return dueTo;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public String getRuc() {
        return ruc;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getValue() {
        return value;
    }
}
