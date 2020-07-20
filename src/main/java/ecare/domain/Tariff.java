package ecare.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tarifftable")
public class Tariff implements Serializable {
    @Id
    @Column(name = "tariff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tariffId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "tariffoption",
                joinColumns = {@JoinColumn(name = "tariff_id")},
                inverseJoinColumns = {@JoinColumn(name = "option_id")})
    private List<Option> optionList;

    public Tariff() {
    }

    public Tariff(Integer tariffId, String title, Double price,List<Option> optionList) {
        this.tariffId = tariffId;
        this.title = title;
        this.price = price;
        this.optionList = optionList;
    }

    public Integer getTariffId() {
        return tariffId;
    }

    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
       this.optionList = optionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return Objects.equals(tariffId, tariff.tariffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tariffId);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "tariffId=" + tariffId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", optionList=" + //optionList +
                '}';
    }
}
