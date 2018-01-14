package com.miningmark48.pearcelbot.commands.music;

import com.miningmark48.pearcelbot.commands.ICommand;
import com.miningmark48.pearcelbot.reference.Reference;
import com.miningmark48.pearcelbot.util.music.handler.AudioHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandRepeatOnce implements ICommand {

    public static final String desc = "Repeat currently playing track once. Run again to disable.";
    public static final String usage = "USAGE: " + Reference.botCommandKey + "repeatonce";
    public static final String info = desc + " " + usage;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        AudioHandler.repeat(event.getTextChannel(), true);
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
