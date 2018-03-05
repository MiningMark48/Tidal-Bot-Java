package com.miningmark48.pearcelbot.commands;

import com.miningmark48.pearcelbot.reference.Reference;
import com.mrpowergamerbr.temmiewebhook.DiscordMessage;
import com.mrpowergamerbr.temmiewebhook.TemmieWebhook;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.time.temporal.ChronoUnit;

public class CommandPing implements ICommand, ICommandPrivate {

    public static final String desc = "Simple Ping, Pong.";
    public static final String usage = "USAGE: " + Reference.botCommandKey + "ping";
    public static final String info = desc + " " + usage;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("\uD83C\uDFD3 **Pong! **...").queue(m -> m.editMessage("\uD83C\uDFD3 **Pong! **" + Math.abs(event.getMessage().getCreationTime().until(m.getCreationTime(), ChronoUnit.MILLIS)) + "ms \uD83D\uDCF6").queue());
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }

    @Override
    public void actionPrivate(String[] args, MessageReceivedEvent event) {
        event.getPrivateChannel().sendMessage("\uD83C\uDFD3 **Pong! **...").queue(m -> m.editMessage("\uD83C\uDFD3 **Pong! **" + event.getMessage().getCreationTime().until(m.getCreationTime(), ChronoUnit.MILLIS) + "ms \uD83D\uDCF6").queue());
    }

    private DiscordMessage getMessage(String content) {
        return new DiscordMessage("Alexa", content, "https://m.media-amazon.com/images/G/01/mobile-apps/dex/avs/docs/ux/branding/mark1._TTH_.png");
    }

}
