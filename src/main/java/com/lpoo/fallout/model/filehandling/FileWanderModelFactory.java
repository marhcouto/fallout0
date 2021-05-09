package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.filehandling.FileArenaFactory;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.VaultBoy;

import java.io.*;

public class FileWanderModelFactory {

    public static WanderModel createWanderModel(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream is = new FileInputStream("resources/" + fileName + ".bin");
        ObjectInputStream ois = new ObjectInputStream(is);

        String arenaName = (String) ois.readObject();
        VaultBoy vaultBoy = (VaultBoy) ois.readObject();
        ois.close();

        Arena arena = FileArenaFactory.createArena(arenaName);
        return new WanderModel(vaultBoy, arena);
    }

}
