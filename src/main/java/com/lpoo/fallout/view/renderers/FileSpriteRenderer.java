package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.model.wander.Position;

import java.io.*;

public class FileSpriteRenderer extends SpriteRenderer<String> {

    public FileSpriteRenderer(String model, Position referencePosition) {
        super(model, referencePosition);
    }

    @Override
    public void buildImage() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/Images/" + model)));

            int letter;
            int column = 0;
            int row = 0;
            while((letter = br.read()) != -1) {
                column++;
                if ((char) letter != ' ')
                    addCharacter(new Position(column, row), (char) letter);
                if ((char) letter == '\n') {
                    column = 0;
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
