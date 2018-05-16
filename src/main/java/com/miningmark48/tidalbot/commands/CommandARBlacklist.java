package com.miningmark48.tidalbot.commands;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import com.miningmark48.tidalbot.commands.base.CommandType;
import com.miningmark48.tidalbot.commands.base.ICommand;
import com.miningmark48.tidalbot.commands.base.ICommandInfo;
import com.miningmark48.tidalbot.reference.Reference;
import com.miningmark48.tidalbot.util.JSON.JSONParseFile;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.*;

public class CommandARBlacklist implements ICommand, ICommandInfo {

    public static String fileName = "ar_blacklist.json";
    private BufferedWriter bufferedWriter = null;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        try {

            File file = new File(fileName);

            if (!file.exists()) {

                Writer writer = new OutputStreamWriter(new FileOutputStream(fileName) , "UTF-8");
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonWriter jw = gson.newJsonWriter(writer);

                jw.beginObject();

                jw.name("blacklist");
                jw.beginArray();

                jw.value(event.getAuthor().getId());

                jw.endArray();

                jw.endObject();

                writer.close();
                successAdd(event);
            } else {
                JsonObject jsonObj = JSONParseFile.JSONParse(fileName);

                Writer writer = new OutputStreamWriter(new FileOutputStream(fileName) , "UTF-8");
                bufferedWriter = new BufferedWriter(writer);

                assert jsonObj != null;
                JsonArray newJson = jsonObj.getAsJsonArray("blacklist");

                if (!newJson.contains(new JsonPrimitive(event.getAuthor().getId()))) {
                    newJson.add(event.getAuthor().getId());
                    successAdd(event);
                } else {
                    newJson.remove(new JsonPrimitive(event.getAuthor().getId()));
                    successRemove(event);
                }

                bufferedWriter.write(jsonObj.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void successAdd(MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Successfully **added** you *(" + event.getAuthor().getId() + ")* to the AutoResponse blacklist.").queue();
    }

    private static void successRemove(MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Successfully **removed** you *(" + event.getAuthor().getId() + ")* from the AutoResponse blacklist.").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String getName() {
        return "arblacklist";
    }

    @Override
    public String getDesc() {
        return "Opt-in to be blacklisted from " + Reference.botName + "'s AutoResponse system";
    }

    @Override
    public String getUsage() {
        return "arblacklist";
    }

    @Override
    public CommandType getType() {
        return CommandType.NORMAL;
    }
}