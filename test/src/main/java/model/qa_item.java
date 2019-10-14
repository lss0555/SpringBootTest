package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class qa_item {
    private int id;
    private String name;
    private String right_answers;
    private String explain;
    private ArrayList<String> sel_items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRight_answers() {
        return right_answers;
    }

    public void setRight_answers(String right_answers) {
        this.right_answers = right_answers;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public ArrayList<String> getSel_items() {
        return sel_items;
    }

    public void setSel_items(ArrayList<String> sel_items) {
        this.sel_items = sel_items;
    }
}
