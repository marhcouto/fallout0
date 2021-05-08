package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.filehandling.FileArenaFactory;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.VaultBoy;

import java.io.*;

public class FileWanderModelFactory {
    private String arenaName;
    private VaultBoy vaultBoy;

    public WanderModel createWanderModel() throws IOException, ClassNotFoundException {
        readGameStatFile();
        Arena arena = new FileArenaFactory(arenaName).createArena();
        return new WanderModel(vaultBoy, arena);
    }

    private void readGameStatFile() throws IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream("resources/gamestat.bin");
        ObjectInputStream ois = new ObjectInputStream(is);

        if (is.available() <= 0) return;

        this.arenaName = (String) ois.readObject();
        this.vaultBoy = (VaultBoy) ois.readObject();
    }

}
