package Model;

public class Subject {
    private int id_sub;
    private String sub_name;
    private String sub_tutor;

    public Subject(){}

    public void setId_sub(int id_sub) {
        this.id_sub = id_sub;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public void setSub_tutor(String sub_tutor) {
        this.sub_tutor = sub_tutor;
    }

    public int getId_sub() {
        return id_sub;
    }

    public String getSub_name() {
        return sub_name;
    }

    public String getSub_tutor() {
        return sub_tutor;
    }

    @Override
    public String toString() {
        return this.id_sub +" "+ this.sub_name+" "+ this.sub_tutor;
    }
}
