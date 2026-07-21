package com.modularmonolithmsaarchitecture.user.application;

import com.modularmonolithmsaarchitecture.common.exception.EntityNotFoundException;
import com.modularmonolithmsaarchitecture.user.application.dto.LoginCommand;
import com.modularmonolithmsaarchitecture.user.application.dto.RegisterUserCommand;
import com.modularmonolithmsaarchitecture.user.application.dto.UserInfo;
import com.modularmonolithmsaarchitecture.user.domain.User;

import com.modularmonolithmsaarchitecture.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserInfo register(RegisterUserCommand command) {
        if(userRepository.existByEmail(command.email())) {
            throw new IllegalStateException("이미 가입된 이메일입니다. email=" + command.email());
        }
        String encoded = passwordEncoder.encode(command.rawPassword());
        User user = User.register(command.email(),encoded,command.name(),command.phoneNumber());
        return UserInfo.from(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserInfo authenticate(LoginCommand command) {
        User user = userRepository.findByEmail(command.email())
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다."));
        if(!passwordEncoder.matches(command.rowPassword(), user.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }
        return UserInfo.from(user);
    }

    @Transactional(readOnly = true)
    public UserInfo getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 유저입니다. UserId=" + userId));
        return UserInfo.from(user);
    }

}
