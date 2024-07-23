package com.mrsurenk.contactmanager.dto;

import java.util.UUID;

public record UserAccountDTO(

        UUID id,

        String email,

        String name,

        String contact,

        String displayPic
) {
}
