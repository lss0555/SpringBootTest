package model;

public class user_paper_items {
    private int id;
    private String name;
    private String qa_type;
    private qa_item qa_item;

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

    public String getQa_type() {
        return qa_type;
    }

    public void setQa_type(String qa_type) {
        this.qa_type = qa_type;
    }

    public model.qa_item getQa_item() {
        return qa_item;
    }

    public void setQa_item(model.qa_item qa_item) {
        this.qa_item = qa_item;
    }
}
