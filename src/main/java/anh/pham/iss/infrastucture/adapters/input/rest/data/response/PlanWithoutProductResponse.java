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
public class PlanWithoutProductResponse {
    private long id;

    private Integer timeLine;


    private List<PlanWithoutProductResponse> childrenPlans;

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

    public List<PlanWithoutProductResponse> getChildrenPlans() {
        return childrenPlans;
    }

    public void setChildrenPlans(List<PlanWithoutProductResponse> childrenPlans) {
        this.childrenPlans = childrenPlans;
    }
}
