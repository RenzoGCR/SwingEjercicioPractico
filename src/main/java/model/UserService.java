package model;

import java.util.Optional;

public interface UserService {
    Optional<Usuario> validate(String correo, String pais, String plataforma);

}
