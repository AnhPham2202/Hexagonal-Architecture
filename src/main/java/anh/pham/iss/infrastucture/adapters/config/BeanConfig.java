package anh.pham.iss.infrastucture.adapters.config;

import anh.pham.iss.application.ports.input.ProductInput;
import anh.pham.iss.application.ports.output.ProductOutput;
import anh.pham.iss.domain.service.PlanService;
import anh.pham.iss.domain.service.ProductService;
import anh.pham.iss.domain.service.SecurityService;
import anh.pham.iss.infrastucture.adapters.output.persistence.PlanPersistenceAdapter;
import anh.pham.iss.infrastucture.adapters.output.persistence.ProductPersistenceAdapter;
import anh.pham.iss.infrastucture.adapters.output.persistence.mapper.PlanMapper;
import anh.pham.iss.infrastucture.adapters.output.persistence.mapper.ProductMapper;
import anh.pham.iss.infrastucture.adapters.output.persistence.repository.PlanRepository;
import anh.pham.iss.infrastucture.adapters.output.persistence.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ProductPersistenceAdapter productPersistenceAdapter(ProductMapper productMapper,
                                                               ProductRepository productRepository,
                                                               PriceCalculationFactory priceCalculationFactory) {
        return new ProductPersistenceAdapter(productMapper, productRepository, priceCalculationFactory);
    }

    @Bean
    public ProductService productService(ProductPersistenceAdapter productPersistenceAdapter, SecurityService securityService) {
        return new ProductService(productPersistenceAdapter, securityService);
    }

    @Bean
    public PlanPersistenceAdapter planPersistenceAdapter(PlanRepository planRepository,
                                                         PlanMapper planMapper) {
        return new PlanPersistenceAdapter(planRepository, planMapper);
    }

    @Bean
    public SecurityService securityService() {
        return new SecurityService();
    }

    @Bean
    public PlanService planService(PlanPersistenceAdapter planPersistenceAdapter,
                                   ProductPersistenceAdapter productPersistenceAdapter) {
        return new PlanService(planPersistenceAdapter, productPersistenceAdapter);
    }

}
