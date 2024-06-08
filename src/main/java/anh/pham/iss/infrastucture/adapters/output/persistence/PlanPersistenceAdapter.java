package anh.pham.iss.infrastucture.adapters.output.persistence;

import anh.pham.iss.application.ports.output.PlanOutput;
import anh.pham.iss.domain.model.PlanModel;
import anh.pham.iss.infrastucture.adapters.output.persistence.mapper.PlanMapper;
import anh.pham.iss.infrastucture.adapters.output.persistence.repository.PlanRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlanPersistenceAdapter implements PlanOutput {
    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    public PlanPersistenceAdapter(PlanRepository planRepository,
                                  PlanMapper planMapper) {
        this.planMapper = planMapper;
        this.planRepository = planRepository;
    }
    @Override
    public PlanModel getPlanById(Long id) throws BadRequestException {
        return planMapper.toPlanModel(planRepository.findById(id).orElseThrow(() -> new BadRequestException("Plan Id Not Found")));
    }

    @Override
    public List<PlanModel> getAllPlansById(List<Long> ids) throws BadRequestException {
        return planMapper.toPlanModelList(planRepository.findAllById(ids));
    }

    @Override
    public List<PlanModel> getAll() {
        return planMapper.toPlanModelList(planRepository.findAll());
    }

    @Override
    public PlanModel savePlan(PlanModel planModel) {
        return planMapper.toPlanModel(
                planRepository.save(
                        planMapper.toPlan(planModel)));
    }
}
