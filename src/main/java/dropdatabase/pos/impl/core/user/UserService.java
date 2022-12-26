package dropdatabase.pos.impl.core.user;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.core.user.dto.UserDto;
import dropdatabase.pos.impl.core.user.dto.UserPostDto;
import dropdatabase.pos.impl.core.user.dto.UserPutDto;

import javax.inject.Inject;
import java.util.UUID;

public class UserService extends Service {
    @Inject
    private UserRepository userRepository;

    public UserDto getById(UUID userId) {
        return getMapper().map(userRepository.getObject(userId), UserDto.class);
    }

    public void put(UUID userId, UserPutDto userPutDto) {
        User user = userRepository.getObject(userId);
        getMapper().map(userPutDto, user);
        userRepository.update(user);
    }

    public void post(UserPostDto userPostDtoDto) {
        User user = userRepository.newObject();
        getMapper().map(userPostDtoDto, user);
        userRepository.save(user);
    }
}
