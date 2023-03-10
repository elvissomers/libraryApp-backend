package wt.bookstore.backend.mapping;

import org.springframework.stereotype.Component;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.SaveUserDto;
import wt.bookstore.backend.dto.UserDto;

@Component
public class UserDtoMapper {
    // TODO: randomized default password
    private String defaultPassword = "1234";

    public User dtoToUser(SaveUserDto saveUserDto){
        /*
         * Used to create a User object from a SaveUserDto object
         */
        User user = new User();
        user.setFirstName(saveUserDto.getFirstName());
        user.setLastName(saveUserDto.getLastName());
        user.setEmailAddress(saveUserDto.getEmailAddress());
        user.setPassword(defaultPassword);
        user.setAdmin(saveUserDto.isAdmin());

        return user;
    }

    public UserDto userToDto(User user){
        /*
         * Used to create a UserDto object from a User object
         */
        UserDto userDto = new UserDto();

        userDto.setAdmin(user.isAdmin());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }
}
