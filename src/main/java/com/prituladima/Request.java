package com.prituladima;

public class Request {

    String type;
    int from;
    int to;

    public Request(String type) {
        this.type = type;
    }

    public Request(String type, int from, int to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }


    public String getType() {
        return type;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
