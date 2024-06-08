package anh.pham.iss.infrastucture.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "products_plans", schema = "public", catalog = "iss")
@IdClass(ProductsPlansPK.class)
public class ProductsPlans {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private long productId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "plan_id")
    private long planId;


}
