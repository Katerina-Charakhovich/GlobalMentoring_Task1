package jmp.main.service;

import jmp.main.service.mapper.UserMapper;
import jmp.database.repository.UserRepository;
import jmp.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    private static final UserMapper userMapper = UserMapper.INSTANCE;

    public void save(UserDto user) {
        userRepository.save(userMapper.userDtoToUser(user));
    }

    public List<UserDto> getAll() {
        return userRepository.getAll().stream().map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }
}
