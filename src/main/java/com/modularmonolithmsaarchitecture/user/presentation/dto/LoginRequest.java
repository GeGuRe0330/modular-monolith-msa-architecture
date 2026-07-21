package com.modularmonolithmsaarchitecture.user.presentation.dto;

import com.modularmonolithmsaarchitecture.user.application.dto.LoginCommand;
import lombok.NonNull;

public record LoginRequest(
        @NonNull String email,
        @NonNull String password
) {
    public LoginCommand toCommand() {
        return new LoginCommand(email, password);
    }
}
