package Model;

/**
 * Created by UX303L on 07.02.2017.
 */
public class Group {
    private int id_group ;
    private int num_group;
    private int st_id;


    public Group(int id_group,int num_group, int st_id){
        this.id_group=id_group;
        this.num_group=num_group;
        this.st_id=st_id;
    }

    public Group() {

    }

    public int getId_group() {
        return id_group;
    }

    public int getNum_group() {
        return num_group;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public void setNum_group(int num_group) {
        this.num_group = num_group;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + this.id_group + " " + this.num_group + " " + this.st_id  + "\n" ;
    }
}

