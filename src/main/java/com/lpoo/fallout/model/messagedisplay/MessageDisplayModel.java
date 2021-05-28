package com.lpoo.fallout.model.messagedisplay;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MessageDisplayModel {
    private final List<String> messages;

    public MessageDisplayModel(@NotNull List<String> messages) {
        this.messages = messages;
    }

    public MessageDisplayModel(@NotNull String... messages) {
        this.messages = Arrays.asList(messages);
    }

    public @NotNull List<String> getMessages() {
        return messages;
    }
}
