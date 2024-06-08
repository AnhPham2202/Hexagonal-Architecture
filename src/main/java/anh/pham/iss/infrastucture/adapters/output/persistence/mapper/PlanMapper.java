package anh.pham.iss.infrastucture.adapters.output.persistence.mapper;

import anh.pham.iss.domain.model.PlanModel;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.CreatePlanRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.PlanWithProductResponse;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.PlanWithoutProductResponse;
import anh.pham.iss.infrastucture.adapters.output.persistence.entity.Plan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanMapper {
    PlanModel toPlanModel(Plan plan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    Plan toPlan(PlanModel plan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    PlanModel toPlanModel(CreatePlanRequest createPlanRequest, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<PlanModel> toPlanModelList(List<Plan> plan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<Plan> toPlanList(List<PlanModel> plan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    PlanWithProductResponse toPlanWithProductResponse(PlanModel planModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    PlanModel toPlanFromWithout(PlanWithoutProductResponse plan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<PlanWithProductResponse> toPlanWithProductResponseList(List<PlanModel> planModels, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<PlanModel> toPlanListFromWithout(List<PlanWithoutProductResponse> plan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Named("fromEntityToModel")
    default PlanModel toPlanModel(Plan plan) {
        return toPlanModel(plan, new CycleAvoidingMappingContext());
    }

    @Named("fromModelToEntity")
    default Plan toPlan(PlanModel planModel) {
        return toPlan(planModel, new CycleAvoidingMappingContext());
    }

    @Named("fromEntityListToModelList")
    default List<PlanModel> toPlanModelList(List<Plan> plan) {
        return toPlanModelList(plan, new CycleAvoidingMappingContext());
    }

    @Named("fromModelListToEntityList")
    default List<Plan> toPlanList(List<PlanModel> planModel) {
        return toPlanList(planModel, new CycleAvoidingMappingContext());
    }

    @Named("fromModelListToResponseList")
    default List<PlanWithProductResponse> toPlanWithProductResponseList(List<PlanModel> planModels) {
        return toPlanWithProductResponseList(planModels, new CycleAvoidingMappingContext());
    }

    @Named("fromResponseListToModelList")
    default List<PlanModel> toPlanListFromWithout(List<PlanWithoutProductResponse> planWithoutProduct) {
        return toPlanListFromWithout(planWithoutProduct, new CycleAvoidingMappingContext());
    }

    @Named("fromModelToResponse")
    default PlanWithProductResponse toPlanWithProductResponse(PlanModel planModel) {
        return toPlanWithProductResponse(planModel, new CycleAvoidingMappingContext());
    }

    @Named("fromCreateRequestToModel")
    default PlanModel toPlanModel(CreatePlanRequest createPlanRequest) {
        return toPlanModel(createPlanRequest, new CycleAvoidingMappingContext());
    }

}
