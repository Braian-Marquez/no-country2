package com.pixiesarg.back.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE equip_entity SET soft_delete = true WHERE id = ?")
@Where(clause = "soft_delete=false")
@NoArgsConstructor
@AllArgsConstructor
public class EquipEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String image;

    @Column(name = "soft_delete")
    private Boolean softDelete = Boolean.FALSE;
}
