package anh.pham.iss.infrastucture.adapters.input.rest.data.request;

import anh.pham.iss.domain.model.PlanModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPlanToPlanRequest {
    private List<Long> oldPlanIds;
    private List<PlanModel> newPlan;
}
