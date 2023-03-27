package wt.bookstore.backend.mapping;

import org.springframework.stereotype.Component;
import wt.bookstore.backend.domains.User;
import wt.bookstore.backend.dto.SaveUserDto;
import wt.bookstore.backend.dto.UserDto;
import wt.bookstore.backend.service.Encryptor;

@Component
public class UserDtoMapper {
    private String defaultPassword = "1234";

    public User dtoToUser(SaveUserDto saveUserDto){
        /*
         * Used to create a User object from a SaveUserDto object
         */
        User user = new User();
        user.setFirstName(saveUserDto.getFirstName());
        user.setLastName(saveUserDto.getLastName());
        user.setEmailAddress(saveUserDto.getEmailAddress());
        user.setPassword(Encryptor.encryptPassword(defaultPassword));
        user.setAdmin(saveUserDto.isAdmin());
        user.setArchived(saveUserDto.isArchived());

        return user;
    }

    public UserDto userToDto(User user){
        /*
         * Used to create a UserDto object from a User object
         */
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setAdmin(user.isAdmin());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setId(user.getId());

        return userDto;
    }
}
