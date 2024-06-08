package anh.pham.iss.domain.service;

import anh.pham.iss.domain.model.PriceCalculationContext;
import anh.pham.iss.domain.model.ProductModel;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service("user2")
public class ProductCalculationAlgorithm2Service implements PriceCalculationContext {
    @Override
    public Double calculate(ProductModel productModel) {

        Double price = ObjectUtils.firstNonNull(productModel.getPrice(), 0d);
        Double quantity = ObjectUtils.firstNonNull(productModel.getQuantity(), 0d);

        return price * quantity;
    }
}
