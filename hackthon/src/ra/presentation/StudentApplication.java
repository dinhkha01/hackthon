package ra.presentation;

import ra.business.StudentBusiness;
import ra.entity.Student;
import ra.validate.ValidateStudent;

import java.util.Scanner;
import static ra.business.StudentBusiness.*;

public class StudentApplication {
    static StudentBusiness studentBusiness = new StudentBusiness();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println(" ----------------------------Student Menu----------------------------");
            System.out.println("1. Hiển thị danh sách sinh viên ");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên\n ");
            System.out.println("4. Xóa sinh viên\n ");
            System.out.println("5. Tìm kiếm sinh viên\n ");
            System.out.println("6. Sắp xếp  ");
            System.out.println("0. Exit");
            System.out.print("Moi ban chon: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    studentBusiness.showAllStudent();
                    break;
                case 2:
                    addCategori();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:

                    break;

                case 5:
    
                    break;
                case 6:
                    sortStudent();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le");

            }
        }
    }
    public static void addCategori(){
        System.out.println("nhap so sv muon them vao: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0 ; i< n; i++){
           studentBusiness.addStudent(sc);
        }
    }
    public static void updateStudent(){
        if(size ==0) {
            System.err.println("Chưa có thông tin của Employee nào cả");
            return;
        }
        System.out.println("Nhập mã nhân viên muốn cập nhật: ");
        String id = sc.nextLine();
        Student student = studentBusiness.findById(id);
        if(student == null){
            System.err.println("Không tìm thấy nhân viên nào với ID: "+id);
            return;
        }
        System.out.println("Thông tin cũ :");
        student.displayDate();
        while(true){
            System.out.println("Nhập thông tin cập nhật cho nhân viên ID: "+id + "Tên Nhân viên: " + student.getStudentName());
            System.out.println("2. Tên");
            System.out.println("3. Năm sinh");
            System.out.println("4. SDT");
            System.out.println("5. goi tinh");
            System.out.println("6. Email");
            System.out.println("7.  ngành học");
            System.out.println("8.  Teen lop");
            System.out.println("9.   điểm tích lũy trung bình");
            System.out.println("0. Thoát");
            System.out.print("Chọn thông tin muốn cập nhật: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 2:
                    student.setStudentName(ValidateStudent.validateName(sc));
                    break;
                case 3:
                    student.setBirthday(ValidateStudent.validateBirthday(sc));
                    break;
                case 4:
                    student.setPhoneNumber(ValidateStudent.validatePhone(sc));
                    break;
                case 5:
                    student.setSex(!student.isSex());
                    break;
                case 6:
                    student.setEmail(ValidateStudent.validateEmail(sc));
                    break;
                case 7:
                    student.setMajor(ValidateStudent.validateMajor(sc));
                    break;

                    case 8:
                    student.setClassName(ValidateStudent.validateClassName(sc));
                    break;
                case  9:
                    student.setGpa(ValidateStudent.validateGpa(sc));
                    break;
                case 0:
                    System.out.println("Thoát cập nhật thông tin nhân viên.");
                    studentBusiness.updateEmployee(student);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }
    public static void sortStudent(){
        while(true){
            System.out.println("1. T");
            System.out.println("2. Năm sinh");
            System.out.println("0. Thoát");
            System.out.print("Chọn thông tin muốn cập nhật: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 2:
                    studentBusiness.sortByNameAscending();
                    break;
                case 3:
                    studentBusiness.sortBySpa();
                    break;
                case 0:
                    System.out.println("Thoát sort.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }

}
