package anh.pham.iss.infrastucture.adapters.input.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithoutPlanResponse {
    private long id;

    private Double quantity;

    private Double totalPrice;

    private Double price;

    private Double depreciation;

    private List<ProductWithoutPlanResponse> subProducts;

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

    public List<ProductWithoutPlanResponse> getSubProducts() {
        return subProducts;
    }

    public void setSubProducts(List<ProductWithoutPlanResponse> subProducts) {
        this.subProducts = subProducts;
    }
}
