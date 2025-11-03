package model;

import java.util.Optional;

public class FileUserService implements UserService {
    private String archivo;
    public FileUserService(String userFile) {
        archivo = userFile;
    }

    @Override
    public Optional<Usuario> validate(String correo, String pais, String plataforma) {
        return Optional.empty();


    }
}
