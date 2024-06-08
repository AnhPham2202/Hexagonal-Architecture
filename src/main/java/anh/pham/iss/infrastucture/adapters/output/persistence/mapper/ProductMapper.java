package anh.pham.iss.infrastucture.adapters.output.persistence.mapper;

import anh.pham.iss.domain.model.ProductModel;
import anh.pham.iss.domain.model.ProductPriceModel;
import anh.pham.iss.infrastucture.adapters.input.rest.data.request.CreateProductRequest;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.ProductPriceResponse;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.ProductWithPlanResponse;
import anh.pham.iss.infrastucture.adapters.input.rest.data.response.ProductWithoutPlanResponse;
import anh.pham.iss.infrastucture.adapters.output.persistence.entity.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toProductModel(Product product, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    ProductModel toProductModel(CreateProductRequest createProductRequest, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    Product toProduct(ProductModel productModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<ProductModel> toProductModelList(List<Product> products, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<Product> toProductList(List<ProductModel> productModels, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    ProductWithPlanResponse toProductWithPlanResponse(ProductModel productModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    Product toProductFromWithout(ProductWithoutPlanResponse productWithoutPlan, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    List<ProductWithPlanResponse> toResponseList(List<ProductModel> products, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    List<Product> toPlanListFromWithout(List<ProductWithoutPlanResponse> productWithoutPlans, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    ProductPriceResponse toProductPriceResponse(ProductPriceModel productPriceModel);

    @Named("fromEntityToModel")
    default ProductModel toProductModel(Product product) {
        return toProductModel(product, new CycleAvoidingMappingContext());
    }
    @Named("fromModelToEntity")
    default Product toProduct(ProductModel productModel) {
        return toProduct(productModel, new CycleAvoidingMappingContext());
    }

    @Named("fromEntityListToModelList")
    default List<ProductModel> toProductModelList(List<Product> product) {
        return toProductModelList(product, new CycleAvoidingMappingContext());
    }
    @Named("fromModelListToEntityList")
    default List<Product> toProductList(List<ProductModel> productModel) {
        return toProductList(productModel, new CycleAvoidingMappingContext());
    }
    @Named("fromModelListToResponseList")
    default List<ProductWithPlanResponse> toResponseList(List<ProductModel> productModels) {
        return toResponseList(productModels, new CycleAvoidingMappingContext());
    }
    @Named("fromResponseListToEntityList")
    default List<Product> toPlanListFromWithout(List<ProductWithoutPlanResponse> productWithoutProduct) {
        return toPlanListFromWithout(productWithoutProduct, new CycleAvoidingMappingContext());
    }
    @Named("fromModelToResponse")
    default ProductWithPlanResponse toProductWithPlanResponse(ProductModel productModel) {
        return toProductWithPlanResponse(productModel, new CycleAvoidingMappingContext());
    }
    @Named("fromResponseToEntity")
    default Product toProductFromWithout(ProductWithoutPlanResponse productWithoutProduct) {
        return toProductFromWithout(productWithoutProduct, new CycleAvoidingMappingContext());
    }

    @Named("fromCreateRequestToModel")
    default ProductModel toProductModel(CreateProductRequest createProductRequest) {
        return toProductModel(createProductRequest, new CycleAvoidingMappingContext());
    }

//    @Named("fromProductPriceModelToResponse")
//    default ProductPriceResponse toProductPriceResponse(ProductPriceModel ProductPriceResponse) {
//        return toProductPriceResponse(ProductPriceResponse, new CycleAvoidingMappingContext());
//    }

}
