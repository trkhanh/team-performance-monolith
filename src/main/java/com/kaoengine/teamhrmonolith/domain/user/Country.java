package com.kaoengine.teamhrmonolith.domain.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    private int number;

    private String commonName;
    private String formalName;
    private String type;
    private String subType;
    private String sovereignty;
    private String capital;
    private String currencyCode;
    private String currencyName;
    private String telephoneCode;
    private String iso316612LetterCode;
    private String iso316613LetterCode;
    private String countryCode;
    private String tldCode;

    @Override
    public String toString() {
        return commonName == null ? "null" : commonName + (formalName != null ? " (" + formalName + ")" : "");
    }
}