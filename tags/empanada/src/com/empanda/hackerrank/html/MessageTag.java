package com.empanda.hackerrank.html;

import java.util.ArrayList;
import java.util.List;

public class MessageTag {
    String message;
    List<String> tags;

    public MessageTag(String message, List<String> tags){
        this.message = message;
        this.tags = new ArrayList<>(tags);
    }

    @Override
    public String toString(){
        if (!message.isEmpty())
            return message + " -> " + tags.toString();
        else
            return "tuvieja";
    }
}
