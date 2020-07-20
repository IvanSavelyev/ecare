package ecare.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contracttable")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Contract implements Serializable {
    @Id
    @Column(name = "contract_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    @Column(name = "number")
    private String number;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Tariff tariff;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "contractmodel",
            joinColumns = {@JoinColumn(name = "contract_id") },
            inverseJoinColumns = {@JoinColumn(name = "tariff_id"), @JoinColumn(name = "option_id")})
    private List<Option> optionList;

    public Contract() {
    }

    public Contract(String number, Tariff tariff, Integer contractId, List<Option> optionList) {
        this.number = number;
        this.tariff = tariff;
        this.optionList = optionList;
        this.contractId = contractId;

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }



    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", number='" + number + '\'' +
                ", tariff=" + tariff +
                ", optionList=" + //optionList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId.equals(contract.contractId) &&
                number.equals(contract.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, number);
    }
}
