package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Element;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

public class FileArenaFactory {

    public static Arena createArena(@NotNull String fileName) throws IOException, ClassNotFoundException {

        Arena arena;
        FileInputStream is = new FileInputStream("resources/arenas/" + fileName + ".bin");
        ObjectInputStream ois = new ObjectInputStream(is);

        arena = (Arena) ois.readObject();
        ois.close();

        return arena;
    }

}
