package com.lpoo.fallout.controller;

import java.io.IOException;

public interface Controller {
    void run() throws IOException, InterruptedException;
    void react() throws IOException;
}
