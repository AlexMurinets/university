package com.example.backend.payload.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;



@Getter @Setter
public class SignUpRequest {
    @NonNull
    private String username;

    @NonNull
    private String email;

    private Set<String> role;

    @NotNull
    @Size(min = 6, max = 40)
    private String password;
}
