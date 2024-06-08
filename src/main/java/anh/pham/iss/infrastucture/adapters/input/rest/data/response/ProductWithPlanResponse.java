package anh.pham.iss.infrastucture.adapters.input.rest.data.response;

import anh.pham.iss.domain.model.PlanModel;
import anh.pham.iss.domain.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithPlanResponse {

    private long id;

    private Double quantity;

    private Double totalPrice;

    private Double price;

    private Double depreciation;

    private List<PlanWithoutProductResponse> plans;
    private List<ProductWithPlanResponse> subProducts;

//    private ProductModel parent;

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

    public List<PlanWithoutProductResponse> getPlans() {
        return plans;
    }

    public void setPlans(List<PlanWithoutProductResponse> plans) {
        this.plans = plans;
    }

    public List<ProductWithPlanResponse> getProducts() {
        return subProducts;
    }

    public void setProducts(List<ProductWithPlanResponse> subProducts) {
        this.subProducts = subProducts;
    }
}
