package anh.pham.iss.infrastucture.adapters.output.persistence;

import anh.pham.iss.application.ports.output.ProductOutput;
import anh.pham.iss.domain.model.ProductModel;
import anh.pham.iss.infrastucture.adapters.config.PriceCalculationFactory;
import anh.pham.iss.infrastucture.adapters.output.persistence.mapper.ProductMapper;
import anh.pham.iss.infrastucture.adapters.output.persistence.repository.ProductRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductPersistenceAdapter implements ProductOutput {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final PriceCalculationFactory priceCalculationFactory;
    public ProductPersistenceAdapter(ProductMapper productMapper,
                                     ProductRepository productRepository, PriceCalculationFactory priceCalculationFactory) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.priceCalculationFactory = priceCalculationFactory;
    }

    @Override
    public ProductModel getProductById(Long id) throws BadRequestException {
        return productMapper.toProductModel(
                productRepository.findById(id)
                        .orElseThrow(() -> new BadRequestException("Product Id not found")));
    }

    @Override
    public List<ProductModel> getAllProductById(List<Long> listIds) {
        return productMapper.toProductModelList(productRepository.findAllById(listIds));
//        return new ArrayList<>();
    }

    @Override
    public ProductModel saveProduct(ProductModel productModel) {
        return productMapper.toProductModel(
                productRepository.save(
                        productMapper.toProduct(productModel)));
    }

    @Override
    public List<ProductModel> getAll() {
        return productMapper.toProductModelList(productRepository.findAll());
    }

    @Override
    public Double calculatePrice(ProductModel productModel) {
        return priceCalculationFactory.calculate(productModel);
    }
}
