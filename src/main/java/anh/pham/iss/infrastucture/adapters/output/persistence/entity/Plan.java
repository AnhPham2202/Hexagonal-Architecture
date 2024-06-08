package anh.pham.iss.infrastucture.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "time_line")
    private Integer timeLine;

//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "childrenPlans", cascade = CascadeType.ALL)
//    @JoinTable(name = "relations_plans", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Plan> parentsPlans;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_plans", joinColumns = @JoinColumn(name = "plan_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

//    @ManyToMany(mappedBy = "parentsPlans", cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "relations_plans", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Plan> childrenPlans;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(Integer timeLine) {
        this.timeLine = timeLine;
    }

    public List<Plan> getParentsPlans() {
        return parentsPlans;
    }

    public void setParentsPlans(List<Plan> parentsPlans) {
        this.parentsPlans = parentsPlans;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Plan> getChildrenPlans() {
        return childrenPlans;
    }

    public void setChildrenPlans(List<Plan> childrenPlans) {
        this.childrenPlans = childrenPlans;
    }
}
