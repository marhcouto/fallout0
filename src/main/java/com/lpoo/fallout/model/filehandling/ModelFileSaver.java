package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.wander.WanderModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModelFileSaver {

    public static void save(String fileName, WanderModel wanderModel) throws IOException {
        ArenaFileSaver.save(wanderModel.getArena().getName(), wanderModel.getArena());
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("resources/" + fileName + ".bin", false));
        os.writeObject(wanderModel.getArena().getName());
        os.writeObject(wanderModel.getVaultBoy());
        os.close();
    }


}
