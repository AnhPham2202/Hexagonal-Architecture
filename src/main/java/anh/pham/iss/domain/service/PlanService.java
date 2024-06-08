package anh.pham.iss.domain.service;

import anh.pham.iss.application.ports.input.PlanInput;
import anh.pham.iss.application.ports.output.PlanOutput;
import anh.pham.iss.application.ports.output.ProductOutput;
import anh.pham.iss.domain.model.PlanModel;
import anh.pham.iss.domain.model.ProductModel;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddPlanToPlanRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddProductToPlanRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

public class PlanService implements PlanInput {

    private final PlanOutput planOutput;
    private final ProductOutput productOutput;

    public PlanService(PlanOutput planOutput, ProductOutput productOutput) {
        this.planOutput = planOutput;
        this.productOutput = productOutput;
    }

    @Override
    public PlanModel getPlanById(Long planId) throws BadRequestException {
        return planOutput.getPlanById(planId);
    }

    @Override
    public PlanModel createPlan(PlanModel planModel) {
        return planOutput.savePlan(planModel);
    }

    @Override
    public List<PlanModel> getAll() {
        return planOutput.getAll();
    }

    @Override
    public PlanModel addProductToPlan(AddProductToPlanRequest addProductToPlanRequest, Long planId) throws BadRequestException {
        PlanModel plan = getPlanById(planId);
        List<ProductModel> oldProducts = productOutput.getAllProductById(addProductToPlanRequest.getOldProductIds());
        oldProducts.addAll(addProductToPlanRequest.getNewProducts());
        plan.setProducts(oldProducts);
        return planOutput.savePlan(plan);
    }

    @Override
    public PlanModel addPlanToPlan(AddPlanToPlanRequest addPlanToPlanRequest, Long planId) throws BadRequestException {
        PlanModel plan = getPlanById(planId);
        List<PlanModel> oldPlans = planOutput.getAllPlansById(addPlanToPlanRequest.getOldPlanIds());
        oldPlans.addAll(addPlanToPlanRequest.getNewPlan());

        plan.setChildrenPlans(oldPlans);
        return planOutput.savePlan(plan);
    }
}
