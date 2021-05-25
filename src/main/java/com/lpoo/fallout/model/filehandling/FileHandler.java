package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class FileHandler {

    public Arena createArena(@NotNull String fileName) throws IOException, ClassNotFoundException {

        Arena arena;
        FileInputStream is = new FileInputStream("resources/arenas/" + fileName + ".bin");
        ObjectInputStream ois = new ObjectInputStream(is);

        arena = (Arena) ois.readObject();
        ois.close();

        return arena;
    }

    public WanderModel createWanderModel(String fileName, Attributes attributes) throws IOException, ClassNotFoundException {
        WanderModel model = createWanderModel(fileName);
        model.getVaultBoy().setAttributes(attributes);
        return model;
    }

    public WanderModel createWanderModel(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream is = new FileInputStream("resources/" + fileName + ".bin");
        ObjectInputStream ois = new ObjectInputStream(is);

        String arenaName = (String) ois.readObject();
        VaultBoy vaultBoy = (VaultBoy) ois.readObject();
        ois.close();

        Arena arena = createArena(arenaName);
        return new WanderModel(vaultBoy, arena);
    }

    public static void saveArena(String fileName, Arena arena) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("resources/arenas/" + fileName + ".bin",false));
        os.writeObject(arena);
        os.close();
    }

    public static void saveModel(String fileName, WanderModel wanderModel) throws IOException {
        saveArena(wanderModel.getArena().getName(), wanderModel.getArena());
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("resources/" + fileName + ".bin", false));
        os.writeObject(wanderModel.getArena().getName());
        os.writeObject(wanderModel.getVaultBoy());
        os.close();
    }
}
