package anh.pham.iss.application.ports.input;

import anh.pham.iss.domain.model.PlanModel;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddPlanToPlanRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddProductToPlanRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface PlanInput {
    PlanModel getPlanById(Long planId) throws BadRequestException;
    PlanModel createPlan(PlanModel plan);
    List<PlanModel> getAll();

    PlanModel addProductToPlan(AddProductToPlanRequest addProductToPlanRequest, Long planId) throws BadRequestException;
    PlanModel addPlanToPlan(AddPlanToPlanRequest addPlanToPlanRequest, Long planId) throws BadRequestException;
}
