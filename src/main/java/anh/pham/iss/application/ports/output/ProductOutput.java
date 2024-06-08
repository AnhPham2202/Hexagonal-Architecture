package anh.pham.iss.application.ports.output;

import anh.pham.iss.domain.model.ProductModel;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ProductOutput {
    ProductModel getProductById(Long id) throws BadRequestException;
    List<ProductModel> getAllProductById(List<Long> listIds);

    ProductModel saveProduct(ProductModel productModel);

    List<ProductModel> getAll();

    Double calculatePrice(ProductModel productModel);
}
