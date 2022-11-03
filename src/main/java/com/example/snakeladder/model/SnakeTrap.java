package com.example.snakeladder.model;

public class SnakeTrap {
    private int begin, end;

    public SnakeTrap(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "SnakeTrap{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
