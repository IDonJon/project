package pe.edu.upc.finanzasbe.repository.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "paidbill")
@Entity
public class PaidBillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paidbill_id", nullable = false)
    private Long paidBillId;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Column(name = "value", nullable = false, precision = 19, scale = 2)
    private BigDecimal value;

    @Column(name = "days", nullable = false)
    private Integer days;

    @Column(name = "tep", nullable = false)
    private Integer tep;

    @Column(name = "d", nullable = false)
    private Integer d;

    @Column(name = "netWorth", nullable = false)
    private Long netWorth;

    @Column(name = "valueYouGet", nullable = false, precision = 19, scale = 2)
    private BigDecimal valueYouGet;

    @Column(name = "tcea", nullable = false)
    private Integer tcea;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private UserEntity user;


    public Long getPaidBillId() { return paidBillId; }

    public void setPaidBillId(Long billId) { this.paidBillId = billId; }

    public String getCompany() { return company; }

    public void setCompany(String company) { this.company = company; }

    public String getRuc() { return ruc; }

    public void setRuc(String ruc) { this.ruc = ruc; }

    public BigDecimal getValue() { return value; }

    public void setValue(BigDecimal value) { this.value = value; }

    public Integer getDays() { return days; }

    public void setDays(Integer days) { this.days = days; }

    public Integer getTep() { return tep; }

    public void setTep(Integer tep) { this.tep = tep; }

    public Integer getD() { return d; }

    public void setD(Integer d) { this.d = d; }

    public Long getNetWorth() { return netWorth; }

    public void setNetWorth(Long netWorth) { this.netWorth = netWorth; }

    public BigDecimal getValueYouGet() { return valueYouGet; }

    public void setValueYouGet(BigDecimal valueYouGet) { this.valueYouGet = valueYouGet; }

    public Integer getTcea() { return tcea; }

    public void setTcea(Integer tcea) { this.tcea = tcea; }

    public UserEntity getUser() { return user; }

    public void setUser(UserEntity user) { this.user = user; }
}
