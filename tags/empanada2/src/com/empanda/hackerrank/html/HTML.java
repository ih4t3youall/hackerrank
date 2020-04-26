package com.empanda.hackerrank.html;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class HTML {

    public static void main(String [] args){
        String fileName= "/home/empanada/Personal/Projects/hackerrank/tags/empanada2/src/com/empanda/hackerrank/html/input.html";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
           tagExtractor(br);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void tagExtractor(BufferedReader br) throws IOException{
        String line;
        List<MessageTag> messages = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            messages.addAll(contabilizarTags(line, tags));
        }
        System.out.println(messages);
    }

    private static List<MessageTag> contabilizarTags(String line, List<String> tagsGlobales) {
        List<MessageTag> messages = new ArrayList<MessageTag>();
        String tag = "";
        String message = "";
        boolean isReadingTag = false;
        boolean isClosingTag = false;
        for (int i = 0; i < line.length(); i++) {
            Character c = line.charAt(i);

            if (c == '<') {
                if (!tagsGlobales.isEmpty() && isMsgNotEmpty(message)) {
                    MessageTag messageTag = new MessageTag(message, tagsGlobales);
                    messages.add(messageTag);
                }
                isReadingTag = true;
                continue;
            }

            if (isReadingTag && c == '/') {
                isClosingTag = true;
                continue;
            }

            if (line.charAt(i) == '>') {
                isReadingTag = false;
                if (isClosingTag) {
                    quitarUltimoTag(tagsGlobales);
                    isClosingTag = false;
                } else {
                    tagsGlobales.add(tag);
                }
                tag = "";
                continue;
            }

            if (isReadingTag){
                tag += c;
                continue;
            }
            if (hayTagsAbiertos(tagsGlobales)) {
                message += line.charAt(i);
                if (i == line.length() - 1){
                    MessageTag messageTag = new MessageTag(message, tagsGlobales);
                    messages.add(messageTag);
                }
            }
        }
        return messages;
    }

    private static boolean isMsgNotEmpty(String message) {
        String messageWitoutSpaces = message.replaceAll("\\s+","");
        return !messageWitoutSpaces.isEmpty();
    }

    private static boolean hayTagsAbiertos(List<String>tags){
        return !tags.isEmpty();
    }

    private static void quitarUltimoTag(List<String> tagsGlobales) {
        tagsGlobales.remove(tagsGlobales.size() - 1);
    }

}

