package anh.pham.iss.infrastucture.adapters.config;

import anh.pham.iss.application.ports.output.SecurityOutput;
import anh.pham.iss.domain.model.PriceCalculationContext;
import anh.pham.iss.domain.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PriceCalculationFactory {
    private final Map<String, PriceCalculationContext> priceCalculationContextMap;
    private final SecurityOutput securityOutput;

    public PriceCalculationFactory(Map<String, PriceCalculationContext> priceCalculationContextMap, SecurityOutput securityOutput) {
        this.priceCalculationContextMap = priceCalculationContextMap;
        this.securityOutput = securityOutput;
    }

    private PriceCalculationContext getPriceCalculationContext(String user) {
        PriceCalculationContext priceCalculationContext = priceCalculationContextMap.get(user);
        if (priceCalculationContext == null) {
            throw new RuntimeException("Unsupported user");
        }

        return priceCalculationContext;
    }

    public Double calculate(ProductModel productModel) {
        PriceCalculationContext priceCalculationContext = getPriceCalculationContext(securityOutput.getAuthentication().getName());
        return priceCalculationContext.calculate(productModel);
    }

}
