package anh.pham.iss.infrastucture.adapters.input.rest.data.request;

import anh.pham.iss.domain.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductToProductRequest {

    private List<Long> oldProductIds;
    private List<ProductModel> newProducts;
}
