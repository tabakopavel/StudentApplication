package Model;

/**
 * Created by UX303L on 07.02.2017.
 */
public class Group_names {
    private int id_group_name;
    private  int num_group;
    private  String group_name;

    public Group_names(int id_group_name,int num_group,String group_name){
        this.id_group_name=id_group_name;
        this.num_group=num_group;
        this.group_name=group_name;
    }

    public Group_names() {

    }

    public int getId_group_name() {
        return id_group_name;
    }

    public int getNum_group() {
        return num_group;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setNum_group(int num_group) {
        this.num_group = num_group;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setId_group_name(int id_group_name) {
        this.id_group_name = id_group_name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + this.id_group_name + " " + this.num_group + " " + this.group_name  + "\n" ;
    }
}
