package anh.pham.iss.infrastucture.adapters.input.rest.data;

import anh.pham.iss.application.ports.input.PlanInput;
import anh.pham.iss.application.ports.output.SecurityOutput;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddPlanToPlanRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddProductToPlanRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.CreatePlanRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.PlanWithProductResponse;
import anh.pham.iss.infrastucture.adapters.output.persistence.mapper.PlanMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlanRestAdapter {

    private final PlanInput planInput;
    private final SecurityOutput securityOutput;
    private final PlanMapper planMapper;

    public PlanRestAdapter(PlanInput planInput,
                           SecurityOutput securityOutput,
                           PlanMapper planMapper) {
        this.planInput = planInput;
        this.securityOutput = securityOutput;
        this.planMapper = planMapper;
    }

    @PostMapping("/plan/{planId}/plan")
    public ResponseEntity<PlanWithProductResponse> addPlanToPlan(@RequestBody AddPlanToPlanRequest addPlanToPlanRequest,
                                                                 @PathVariable Long planId) throws BadRequestException {
        return ResponseEntity.ok(planMapper.toPlanWithProductResponse(planInput.addPlanToPlan(addPlanToPlanRequest, planId)));
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<PlanWithProductResponse> getPlan(@PathVariable Long planId) throws BadRequestException {
        return ResponseEntity.ok(planMapper.toPlanWithProductResponse(planInput.getPlanById(planId)));
    }

    @GetMapping("/plan")
    public ResponseEntity<List<PlanWithProductResponse>> getAll() {
        securityOutput.getAuthentication().getName();
        return ResponseEntity.ok(planMapper.toPlanWithProductResponseList(planInput.getAll()));
    }

    @PostMapping("/plan")
    public ResponseEntity<PlanWithProductResponse> createPlan(@RequestBody CreatePlanRequest createPlanRequest) {
        return ResponseEntity.ok(
                planMapper.toPlanWithProductResponse(
                        planInput.createPlan(planMapper.toPlanModel(createPlanRequest))));
    }

    @PostMapping("/plan/{planId}/product")
    public ResponseEntity<PlanWithProductResponse> addProductsToPlan(@RequestBody AddProductToPlanRequest addProductToPlanRequest,
                                                  @PathVariable Long planId) throws BadRequestException {
        return ResponseEntity.ok(
                planMapper.toPlanWithProductResponse(
                        planInput.addProductToPlan(addProductToPlanRequest, planId)));
    }
}
