package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.model.filehandling.ArenaFileSaver;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.VaultBoy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ModelFileSaver {
    private final WanderModel wanderModel;

    public ModelFileSaver(WanderModel wanderModel) {
        this.wanderModel = wanderModel;
    }

    public void save() throws IOException {
        new ArenaFileSaver(wanderModel.getArena()).save();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("resources/gamestat.bin"));
        os.writeObject(wanderModel.getArena().getName());
        os.writeObject(wanderModel.getVaultBoy());
        os.close();
    }


}
