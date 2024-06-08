package anh.pham.iss.infrastucture.adapters.input.rest.data.request;

import anh.pham.iss.domain.model.PlanModel;
import anh.pham.iss.domain.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePlanRequest {
    private long id;

    private Integer timeLine;

    private List<ProductModel> products;

    private List<PlanModel> childrenPlans;

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

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public List<PlanModel> getChildrenPlans() {
        return childrenPlans;
    }

    public void setChildrenPlans(List<PlanModel> childrenPlans) {
        this.childrenPlans = childrenPlans;
    }
}
