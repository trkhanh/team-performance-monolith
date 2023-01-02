package com.kaoengine.teamhrmonolith.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Salutation implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

}
