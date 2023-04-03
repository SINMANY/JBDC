package model;


public class Student {
    private Integer id;
    private String name;
    private String gender;
    private String classname;
    private Float score;

    public Student(){}

    public Student(Integer id, String name, String gender, String classname, Float score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classname = classname;
        this.score = score;
    }

    public Student(String name, String gender, String classname, Float score) {
    }


    public String getName() {
        return name;
    }

    public void setName(String studentname) {
        this.name = studentname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classname='" + classname + '\'' +
                ", score=" + score +
                '}';
    }}


