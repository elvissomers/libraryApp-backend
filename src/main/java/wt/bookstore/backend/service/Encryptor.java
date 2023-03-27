package wt.bookstore.backend.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import wt.bookstore.backend.dto.UserDto;

import java.util.stream.Stream;

public class Encryptor {
    public static String encryptPassword(String password) {
        return BCrypt.withDefaults().hashToString(10, password.toCharArray());
    }

    public static Boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }

}
