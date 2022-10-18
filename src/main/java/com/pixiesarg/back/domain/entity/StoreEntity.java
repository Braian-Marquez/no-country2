package com.pixiesarg.back.domain.entity;

import com.pixiesarg.back.domain.assets.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreEntity {
    @Id
    private Long id;

    @OneToMany
    private List<Head> head;

    @OneToMany
    private List<Hair>hair;

    @OneToMany
    private List<BodyAssets> body;

    @OneToMany
    private List<Legs> legs;

    @OneToMany
    private List<Hand> hand;

    @OneToMany
    private List<Pet> pets;

}
