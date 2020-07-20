package ecare.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "optiontable")
public class Option implements Serializable {
    @Id
    @Column(name = "option_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optionId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "cost")
    private Integer cost;

    public Option() {
    }

    public Option(Integer optionId, String title, Integer price, Integer cost) {
        this.optionId = optionId;
        this.title = title;
        this.price = price;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return title.equals(option.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + optionId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                '}';
    }

}
