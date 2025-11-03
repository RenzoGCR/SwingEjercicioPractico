package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class FileUserService implements UserService {
    private String archivo;
    public FileUserService(String userFile) {
        archivo = userFile;
    }
    private static Logger logger = Logger.getLogger(FileUserService.class.getName());
    private static Integer lastId = -1;


    @Override
    public Optional<Usuario> validate(String correo, String pais, String plataforma) {
        return Optional.empty();


    }
    public List<Usuario> findAll() {
        var salida = new ArrayList<Usuario>();

        logger.info("Abriendo archivo");
        try( BufferedReader br = new BufferedReader(new FileReader( new File(archivo) ))){
            var contenido = br.lines();

            contenido.forEach(line -> {
                String[] lineArray = line.split(",");
                if(lineArray.length < 12) {
                    logger.severe("Linea mal formada");
                } else {
                    Usuario usuario = new Usuario();
                    usuario.setCorreo(lineArray[0]);
                    usuario.setPais(lineArray[1]);
                    usuario.setPlataforma(lineArray[2]);
                    salida.add(usuario);
                }
            });
            lastId = salida.size();
            logger.info("Actualizo tamaño: " + lastId);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }
}
