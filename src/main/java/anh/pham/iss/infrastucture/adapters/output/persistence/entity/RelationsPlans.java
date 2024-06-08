package anh.pham.iss.infrastucture.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "relations_plans", schema = "public", catalog = "iss")
@IdClass(RelationsPlansPK.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelationsPlans {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "parent_id")
    private long parentId;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "child_id")
    private long childId;

}
