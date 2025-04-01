package ra.entity;

import ra.business.StudentBusiness;
import ra.validate.ValidateStudent;

import java.util.Scanner;

public class Student implements IApp{
    private String studentId;
    private String studentName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status;

    public Student() {
    }

    public Student(String studentId, String studentName, String birthday, String phoneNumber, boolean sex, String email, String major, String className, float gpa, byte status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.major = major;
        this.className = className;
        this.gpa = gpa;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        studentName = ValidateStudent.validateName(sc);
        birthday = ValidateStudent.validateBirthday(sc);
        phoneNumber = ValidateStudent.validatePhone(sc);
        sex = ValidateStudent.validateSex(sc);
        email = ValidateStudent.validateEmail(sc);
        major = ValidateStudent.validateMajor(sc);
        className = ValidateStudent.validateClassName(sc);
        gpa = ValidateStudent.validateGpa(sc);
        status = 1;
    }

    @Override
    public void displayDate() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Birthday: " + birthday);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Sex: " + (sex? "Male" : "Female"));
        System.out.println("Email: " + email);
        System.out.println("Major: " + major);
        System.out.println("Class Name: " + className);
        System.out.println("GPA: " + gpa);
        System.out.println("Status: " + (status == 1 || status == 2 || status == 3 ? "Active" : "Inactive"));
        System.out.println("================================================================");

    }
}
