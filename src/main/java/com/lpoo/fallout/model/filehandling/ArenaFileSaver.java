package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Element;
import com.lpoo.fallout.model.wander.element.Wall;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArenaFileSaver {
    protected final Arena arena;

    public ArenaFileSaver(Arena arena) {
        this.arena = arena;
    }

    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("resources/arenas/" +
                this.arena.getName() + ".bin"));
        os.writeObject(this.arena);
        os.close();
    }
}
