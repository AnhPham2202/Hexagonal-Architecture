package anh.pham.iss.domain.service;

import anh.pham.iss.application.ports.input.ProductInput;
import anh.pham.iss.application.ports.output.ProductOutput;
import anh.pham.iss.application.ports.output.SecurityOutput;
import anh.pham.iss.domain.model.PriceCalculationContext;
import anh.pham.iss.domain.model.ProductModel;
import anh.pham.iss.domain.model.ProductPriceModel;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddProductToProductRequest;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;

import java.util.List;

//@AllArgsConstructor
public class ProductService implements ProductInput {

    private final ProductOutput productOutput;
    private final SecurityOutput securityOutput;

    public ProductService(ProductOutput productOutput, SecurityOutput securityOutput) {
        this.productOutput = productOutput;
        this.securityOutput = securityOutput;
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        return productOutput.saveProduct(productModel);
    }

    @Override
    public ProductModel getProductById(Long id) throws BadRequestException {
        return productOutput.getProductById(id);
    }

    @Override
    public List<ProductModel> getAll() {
        return productOutput.getAll();
    }

    @Override
    public List<ProductModel> getAllProductById(List<Long> listIds) throws BadRequestException {
        return productOutput.getAllProductById(listIds);
    }

    @Override
    public ProductModel addProductToProduct(AddProductToProductRequest addProductToProductRequest, Long productId) throws BadRequestException {
        ProductModel productModel = getProductById(productId);
        List<ProductModel> productsToAdd = getAllProductById(addProductToProductRequest.getOldProductIds());
        productsToAdd.addAll(addProductToProductRequest.getNewProducts());

        productModel.setSubProducts(productsToAdd);
        return productOutput.saveProduct(productModel);
    }

    @Override
    public ProductPriceModel calculatePrice(Long productId) throws BadRequestException {
        ProductModel productModel = getProductById(productId);

        return ProductPriceModel
                .builder()
                .price(productOutput.calculatePrice(productModel))
                .productId(productId)
                .user(securityOutput.getAuthentication().getName())
                .build();
    }

}
