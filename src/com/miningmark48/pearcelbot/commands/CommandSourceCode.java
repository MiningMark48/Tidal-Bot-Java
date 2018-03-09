package com.miningmark48.pearcelbot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandSourceCode implements ICommand, ICommandInfo {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("**Source code for Pearcel Bot:** _https://github.com/MiningMark48/Pearcel-Bot_").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String getName() {
        return "sourcecode";
    }

    @Override
    public String getDesc() {
        return "Get the link for Pearcel Bot source code.";
    }

    @Override
    public String getUsage() {
        return "sourcecode";
    }

    @Override
    public CommandType getType() {
        return CommandType.NORMAL;
    }
}
