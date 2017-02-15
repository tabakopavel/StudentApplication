package Model;

/**
 * Created by UX303L on 06.02.2017.
 */
public class Student {
    private int id_st;
    private String st_name;
    private String st_surname;
    private String st_ph_num;
    private String num_st_book;
    private int year;

    public Student(int id_st, String st_name, String st_surname, String st_ph_num, String num_st_book, int year) {
        this.st_name = st_name;
        this.st_surname = st_surname;
        this.id_st= id_st;
        this.st_ph_num = st_ph_num;
        this.num_st_book = num_st_book;
        this.year = year;
    }

    public Student() {

    }

    public int getId_st() {
        return id_st;
    }

    public String getNum_st_book() {
        return num_st_book;
    }

    public int getYear() {
        return year;
    }

    public String getSt_name() {
        return st_name;
    }

    public String getSt_ph_num() {
        return st_ph_num;
    }

    public String getSt_surname() {
        return st_surname;
    }

    public void setId_st(int id_st) {
        this.id_st = id_st;
    }

    public void setNum_st_book(String num_st_book) {
        this.num_st_book = num_st_book;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public void setSt_ph_num(String st_ph_num) {
        this.st_ph_num = st_ph_num;
    }

    public void setSt_surname(String st_surname) {
        this.st_surname = st_surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return this.id_st + " " + this.st_name + " " + this.st_surname +  " " + this.st_ph_num + " " + this.num_st_book + " " + this.year;
    }
}
