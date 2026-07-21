package com.modularmonolithmsaarchitecture.user.application.dto;

import com.modularmonolithmsaarchitecture.user.domain.User;

public record UserInfo(
        Long id,
        String email,
        String name,
        String phoneNumber
) {
    public static UserInfo from(User user) {
        return new UserInfo(user.getId(), user.getEmail(), user.getName(), user.getPhoneNumber());
    }
}
