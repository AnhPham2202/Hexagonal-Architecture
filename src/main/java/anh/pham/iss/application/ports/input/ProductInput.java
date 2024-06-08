package anh.pham.iss.application.ports.input;

import anh.pham.iss.domain.model.ProductModel;
import anh.pham.iss.domain.model.ProductPriceModel;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddProductToProductRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ProductInput {
    ProductModel createProduct(ProductModel product);

    ProductModel getProductById(Long id) throws BadRequestException;
    List<ProductModel> getAll();
    List<ProductModel> getAllProductById(List<Long> listIds) throws BadRequestException;

    ProductModel addProductToProduct(AddProductToProductRequest addProductToProductRequest, Long productId) throws BadRequestException;


    ProductPriceModel calculatePrice(Long productId) throws BadRequestException;
}
