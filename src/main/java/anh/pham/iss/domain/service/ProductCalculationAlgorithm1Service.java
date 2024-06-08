package anh.pham.iss.domain.service;

import anh.pham.iss.application.ports.output.SecurityOutput;
import anh.pham.iss.domain.model.PriceCalculationContext;
import anh.pham.iss.domain.model.ProductModel;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service("user1")
public class ProductCalculationAlgorithm1Service implements PriceCalculationContext {
    @Override
    public Double calculate(ProductModel productModel) {
        Double price = ObjectUtils.firstNonNull(productModel.getPrice(), 0d);
        Double quantity = ObjectUtils.firstNonNull(productModel.getQuantity(), 0d);
        Double depreciation = ObjectUtils.firstNonNull(productModel.getDepreciation(), 1d);

        return price * quantity * depreciation;
    }
}
