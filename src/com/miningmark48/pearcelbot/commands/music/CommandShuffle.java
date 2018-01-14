package com.miningmark48.pearcelbot.commands.music;

import com.miningmark48.pearcelbot.commands.ICommand;
import com.miningmark48.pearcelbot.reference.Reference;
import com.miningmark48.pearcelbot.util.music.handler.AudioHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandShuffle implements ICommand {

    public static final String desc = "Shuffle the current queue.";
    public static final String usage = "USAGE: " + Reference.botCommandKey + "shuffle [amount]";
    public static final String info = desc + " " + usage;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        AudioHandler.shuffle(event.getTextChannel(), args);
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
