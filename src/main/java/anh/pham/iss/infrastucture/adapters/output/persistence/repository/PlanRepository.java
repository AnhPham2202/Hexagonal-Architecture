package anh.pham.iss.infrastucture.adapters.output.persistence.repository;

import anh.pham.iss.infrastucture.adapters.output.persistence.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
