package anh.pham.iss.infrastucture.adapters.input.rest.data;

import anh.pham.iss.application.ports.input.ProductInput;
import anh.pham.iss.application.ports.output.ProductOutput;
import anh.pham.iss.domain.model.ProductModel;
import anh.pham.iss.domain.service.ProductService;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.AddProductToProductRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.CreateProductRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.ProductPriceResponse;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.ProductWithPlanResponse;
import anh.pham.iss.infrastucture.adapters.output.persistence.entity.Product;
import anh.pham.iss.infrastucture.adapters.output.persistence.mapper.ProductMapper;
import anh.pham.iss.infrastucture.adapters.output.persistence.repository.ProductRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductRestAdapter {

    private final ProductInput productInput;
    private final ProductMapper productMapper;

    public ProductRestAdapter(ProductInput productInput,
                              ProductMapper productMapper) {
        this.productInput = productInput;
        this.productMapper = productMapper;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductWithPlanResponse> getProductById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.ok(productMapper.toProductWithPlanResponse(productInput.getProductById(id)));
    }

    @PostMapping("/product")
    public ResponseEntity<ProductWithPlanResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(
                productMapper.toProductWithPlanResponse(
                        productInput.createProduct(
                                productMapper.toProductModel(createProductRequest)
                        )));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductWithPlanResponse>> getAll() {
        return ResponseEntity.ok(productMapper.toResponseList(productInput.getAll()));
    }

    @PostMapping("/product/{productId}")
    public ResponseEntity<ProductWithPlanResponse> addProductToProduct(@PathVariable Long productId,
                                                                       @RequestBody AddProductToProductRequest addProductToProductRequest) throws BadRequestException {
        return ResponseEntity.ok(
                productMapper.toProductWithPlanResponse(
                        productInput.addProductToProduct(addProductToProductRequest, productId)));
    }

    @GetMapping("/product/{productId}/price")
    public ResponseEntity<ProductPriceResponse> calculatePrice(@PathVariable Long productId) throws BadRequestException {
        return ResponseEntity.ok(
                productMapper.toProductPriceResponse(
                        productInput.calculatePrice(productId)));
    }

}
