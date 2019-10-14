package model;

import java.util.ArrayList;

public class Data {
    private String status;
    private String user_paper_id;
    private int timeout;
    ArrayList<user_paper_items> user_paper_items;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_paper_id() {
        return user_paper_id;
    }

    public void setUser_paper_id(String user_paper_id) {
        this.user_paper_id = user_paper_id;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public ArrayList<model.user_paper_items> getUser_paper_items() {
        return user_paper_items;
    }

    public void setUser_paper_items(ArrayList<model.user_paper_items> user_paper_items) {
        this.user_paper_items = user_paper_items;
    }
}
