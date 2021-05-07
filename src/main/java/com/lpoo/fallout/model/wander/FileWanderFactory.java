package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Attributes;
import com.lpoo.fallout.model.Position;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileWanderFactory implements WanderFactory {
    private final String filename;
    private final VaultBoy vaultBoy;

    public FileWanderFactory(@NotNull String filename, @NotNull VaultBoy vaultBoy) {
        this.filename = filename;
        this.vaultBoy = vaultBoy;
    }

    public WanderModel createWanderModel() {

        //TODO Not yet implemented
        return new WanderModel(this.vaultBoy);

    }

    public void readFromFile() throws FileNotFoundException, IOException {
        URL resource = this.getClass().getResource(this.filename);
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        int dimensions = br.read();
        System.out.println(dimensions);

    }
}
