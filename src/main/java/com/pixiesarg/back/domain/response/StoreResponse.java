package com.pixiesarg.back.domain.response;

import com.pixiesarg.back.domain.assets.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class StoreResponse {


    private List<Head> head;

    private List<Hair>hair;

    private List<BodyAssets> body;

    private List<Legs> legs;

    private List<Hand> hand;

    private List<Pet> pets;
}
