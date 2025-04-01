package ra.business;

import ra.entity.Student;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StudentBusiness {
    public static Student[] students;
    public static int size;

    public  String randomId(){
        Random rad = new Random();
        while (true) {
            String id = "SV" + String.format("%05d", rad.nextInt(100000));
            if (isIdUnique(id)) {
                return id;
            }
        }
    }
    public boolean isIdUnique(String studentId){
        for (int i = 0 ; i < size ; i++){
            if (students[i].getStudentId().equals(studentId)){
                return false;
            }
        }
        return true;
    }
    public  void showAllStudent(){
        if(size ==0){
            System.out.println("Danh sách r��ng");
            return;
        }
        for(int i=0; i < size; i++){
            students[i].displayDate();
        }
    }
    public void addStudent(Scanner sc){
        Student student = new Student();
        student.inputData(sc);
        student.setStudentId(randomId());
        students[size]= student;
        size++;
    }
    public Student findById(String id){
        for(int i =0 ; i < size; i++){
            if(students[i].getStudentId().equals(id)) return students[i];
        }

        return null;
    }
    public  void updateEmployee(Student student ){
        for(int i = 0 ; i < size; i++){
            if(students[i].getStudentId().equals(student.getStudentId())){
                students[i] = student;
                return;
            }
        }
    }
    public void deleteStudent(String id){

        int index = findIndexById(id);
        if(index != -1){
            for(int i = index; i < size -1; i++){
                students[i] = students[i + 1];
            }
            size--;
        }
    }
    public  int findIndexById(String id){
        for(int i =0 ; i < size; i++){
            if(students[i].getStudentId().equals(id)) return i;
        }
        System.err.println(("không tìm thấy ID: "+id));
        return -1;
    }
    public void searchByName(String name) {
        Student[] result = new Student[size];
        int count = 0;
        for (Student employee : students) {
            if (employee != null && employee.getStudentName() != null) {
                // Chuyển tên nhân viên và keyword về chữ thường để so sánh không phân biệt hoa/thường
                String employeeName = employee.getStudentName().toLowerCase();
                // Kiểm tra tên nhân viên có CHỨA keyword hay không
                if (employeeName.contains(name.toLowerCase())) {
                    result[count] = employee;
                    count++;
                }
            }
        }
        showInfor(Arrays.copyOf(result, count)) ;
    }
    public void searchByClassname(String className) {
        Student[] result = new Student[size];
        int count = 0;
        for (Student employee : students) {
            if (employee != null && employee.getClassName() != null) {
                // Chuyển tên nhân viên và keyword về chữ thường để so sánh không phân biệt hoa/thường
                String employeeName = employee.getClassName().toLowerCase();
                // Kiểm tra tên nhân viên có CHỨA keyword hay không
                if (employeeName.contains(className.toLowerCase())) {
                    result[count] = employee;
                    count++;
                }
            }
        }
        showInfor(Arrays.copyOf(result, count)) ;
    }
    public void showInfor(Student[] students){
        if(students.length ==0) return;
        System.out.println("Danh sách nhân viên tìm thấy");
        for (Student student : students){
            student.displayDate();
        }
    }
    public void sortBySpa() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (students[i].getGpa() > students[j].getGpa()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp thành công theo GPA (giảm dần)");
        showAllStudent();
    }
    public void sortByNameAscending() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {

                if (students[i].getStudentName().compareToIgnoreCase(students[j].getStudentName()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp thành công theo tên (A-Z)");
        showAllStudent();
    }
}
