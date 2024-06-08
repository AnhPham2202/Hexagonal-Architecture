package anh.pham.iss.infrastucture.adapters.output.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "quantity")
    private Double quantity;

    @Basic
    @Column(name = "total_price")
    private Double totalPrice;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "depreciation")
    private Double depreciation;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Plan> plans;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Product parent;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
//    @JsonIgnore
    private List<Product> subProducts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(Double depreciation) {
        this.depreciation = depreciation;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public Product getParent() {
        return parent;
    }

    public void setParent(Product parent) {
        this.parent = parent;
    }

    public List<Product> getSubProducts() {
        return subProducts;
    }

    public void setSubProducts(List<Product> subProducts) {
        this.subProducts = subProducts;
    }
}
