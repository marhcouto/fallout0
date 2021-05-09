package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.wander.Arena;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ArenaFileSaver {

    public static void save(String fileName, Arena arena) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("resources/arenas/" + fileName + ".bin",false));
        os.writeObject(arena);
        os.close();
    }
}
