package com.floproje.StokYonetim.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("Administrator"),
    MANAGER("Manager"),
    PERSONNEL("Personnel");

    private final String name;

    Role(String name) {
        this.name = name;
    }
}
