package anh.pham.iss.domain.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanModel {
    private long id;

    private Integer timeLine;

//    private List<PlanModel> parentsPlans;

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

//    public List<PlanModel> getParentsPlans() {
//        return parentsPlans;
//    }
//
//    public void setParentsPlans(List<PlanModel> parentsPlans) {
//        this.parentsPlans = parentsPlans;
//    }

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
