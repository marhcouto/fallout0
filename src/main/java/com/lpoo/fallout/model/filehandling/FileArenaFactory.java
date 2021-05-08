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
    private final String arenaName;

    public FileArenaFactory(@NotNull String arenaName) {
        this.arenaName = arenaName;
    }

    public Arena createArena() throws IOException, ClassNotFoundException {

        Arena arena;
        FileInputStream is = new FileInputStream("resources/arenas/" + arenaName + ".bin");
        ObjectInputStream ois = new ObjectInputStream(is);
        if (is.available() <= 0) return null; //TODO Fix this
        arena = (Arena) ois.readObject();

        return arena;
    }

    /*private void readFromFile(List<? extends Element> elements) throws IOException, ClassNotFoundException {

        FileInputStream is = new FileInputStream("resources/arenas/" + arenaName + "/walls.bin");
        ObjectInputStream ois = new ObjectInputStream(is);

        while(is.available() > 0) {
            Wall w = (Wall) ois.readObject();
            elements.add(w);
        }

        ois.close();
    }*/
}
