package Model;

/**
 * Created by UX303L on 07.02.2017.
 */
public class Omissions {

    private int st_id;
    private  int mathematic;
    private  int english;
    private  int biology;
    private  int chemistry;
    private int sum;



    public Omissions(int st_id,int mathematic,int english ,int biology,int chemistry, int sum){
        this.st_id=st_id;
        this.mathematic=mathematic;
        this.english=english;
        this.biology=biology;
        this.chemistry=chemistry;
        this.sum=sum;
    }

    public int getSt_id() {
        return st_id;
    }

    public int getBiology() {
        return biology;
    }

    public int getChemistry() {
        return chemistry;
    }

    public int getEnglish() {
        return english;
    }

    public int getMathematic() {
        return mathematic;
    }

    public int getSum() {
        return sum;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setMathematic(int mathematic) {
        this.mathematic = mathematic;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +  this.st_id + " " + this.mathematic + " " + this.english +  " " + this.biology + " " + this.chemistry + " " + this.sum + "\n" ;
    }
}
