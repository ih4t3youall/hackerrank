package com.empanada.tdd.chess.model.table.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HTML {

    public static void main(String [] args){
        String fileName= "/home/empanada/Personal/Projects/hackerrank/tags/input.html";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
           tagExtractor(br);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void tagExtractor(BufferedReader br) throws IOException{
        String line;
        Map<String, Integer> tagsResult = new HashMap<>();
        while ((line = br.readLine()) != null) {
            tagsResult = contabilizarTags(line, tagsResult);

        }
        System.out.println(tagsResult.keySet());
    }

    private static Map<String, Integer> contabilizarTags(String line, Map<String, Integer> tagsResult) {
        String tag = "";
        boolean isTagOpen = false;
        boolean isClosingTag = false;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '>'){
                isTagOpen = false;
                if (isClosingTag){
                    tag += -1;
                    isClosingTag = false;
                }
                System.out.println(tag);
                tag = "";
            }
            if (isTagOpen) {
                if (line.charAt(i) != '/') {
                    tag += line.charAt(i);
                }
                else
                    isClosingTag = true;
            }

            if (line.charAt(i) == '<'){
                isTagOpen = true;
            }
//
//            if (isTagOpen) {
//                if (line.charAt(i)== '>') {
//                    System.out.println(tag);
//                    tagsResult.putIfAbsent(tag, 1);
//                    tagsResult.put(tag, tagsResult.get(tag) + 1);
//                    tag = "";
//                    isTagOpen = false;
//                }
//            }


        }
        return tagsResult;
    }


}
