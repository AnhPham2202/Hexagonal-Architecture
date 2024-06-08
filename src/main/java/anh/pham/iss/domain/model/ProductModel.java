package anh.pham.iss.domain.model;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {

    private long id;

    private Double quantity;

    private Double totalPrice;

    private Double price;

    private Double depreciation;

    private List<PlanModel> plans;

//    private ProductModel parent;

    private List<ProductModel> subProducts;

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

    public List<PlanModel> getPlans() {
        return plans;
    }

    public void setPlans(List<PlanModel> plans) {
        this.plans = plans;
    }

    public List<ProductModel> getSubProducts() {
        return subProducts;
    }

    public void setSubProducts(List<ProductModel> subProducts) {
        this.subProducts = subProducts;
    }
}
