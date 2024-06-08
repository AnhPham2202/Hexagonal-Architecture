package anh.pham.iss.application.ports.output;

import anh.pham.iss.domain.model.PlanModel;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface PlanOutput {
    PlanModel getPlanById(Long id) throws BadRequestException;
    List<PlanModel> getAllPlansById(List<Long> ids) throws BadRequestException;
    List<PlanModel> getAll();

    PlanModel savePlan(PlanModel planModel);

}
