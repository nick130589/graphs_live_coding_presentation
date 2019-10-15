package com.prituladima;

public class Request {

    char type;
    int from;
    int to;

    public Request(char type) {
        this.type = type;
    }

    public Request(char type, int from, int to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }


    public char getType() {
        return type;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
