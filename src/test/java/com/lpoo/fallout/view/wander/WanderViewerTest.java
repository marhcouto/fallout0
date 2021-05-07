package com.lpoo.fallout.view.Wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.gui.LanternaTerminal;
import com.lpoo.fallout.model.wander.RandomWanderFactory;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WanderViewerTest {
    @Test
    public void TESTEDOTESTE() throws IOException, InterruptedException {
        LanternaGUI gui = new LanternaGUI(new LanternaTerminal());
        WanderModel model = new RandomWanderFactory(10, 10, 0).createWanderModel();
        WanderViewer viewer = new WanderViewer(gui, model);
        viewer.draw();
        Thread.sleep(10*1000);
    }
}