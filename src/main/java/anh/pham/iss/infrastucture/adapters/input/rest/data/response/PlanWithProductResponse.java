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
public class PlanWithProductResponse {
    private long id;

    private Integer timeLine;


    private List<ProductWithoutPlanResponse> products;

    private List<PlanWithProductResponse> childrenPlans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(Integer timeLine) {
        this.timeLine = timeLine;
    }

    public List<ProductWithoutPlanResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithoutPlanResponse> products) {
        this.products = products;
    }

    public List<PlanWithProductResponse> getChildrenPlans() {
        return childrenPlans;
    }

    public void setChildrenPlans(List<PlanWithProductResponse> childrenPlans) {
        this.childrenPlans = childrenPlans;
    }
}
