package ra.validate;

import java.util.Scanner;

public class ValidateStudent {
    public static String validateName(Scanner sc){
        return InputMethod.inputString(sc,"Nhập Tên sinh viên", "Tên sinh viên không được để trống");
    }
    public static String validateBirthday(Scanner sc){
        while(true) {
            String birthday = InputMethod.inputString(sc, "Nhập ngày sinh (định dạng dd/MM/yyyy)", "ngày sinh không được để trống");
            String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
            if( birthday.matches(regex)){
                return birthday;
            }
            System.err.println("Ngày sinh nhập không đúng đ��nh dạng dd/MM/yyyy");
        }
    }
    public static String validatePhone(Scanner sc){
        while(true ){
            String phone = InputMethod.inputString(sc,"Nhập Số điện thoại (định dạng 09XXXXXX)", "Số điện thoại không được để trống");
            String regex = "\t^(03|05|07|08|09)d{7}$";
            if(phone.matches(regex)){
                return phone;
            }
            System.err.println("Số điện thoại nhập không đúng đinh dạng 09XXXXXXX");

        }
    }

    public static boolean validateSex(Scanner sc){
        return InputMethod.inputBoolean(sc,"Nhập giới tính (true - Nam , false - Nữ)","dữ liệu khong hợp lệ nhập lại đê");
    };
    public static String validateEmail(Scanner sc){
        while(true)
            {
                String email = InputMethod.inputString(sc,"Nhập Email","Email không được để trống");
                String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
                if(email.matches(regex)){
                    return email;
                }
                System.err.println("Email nhập không đúng đinh dạng");
            }
    }
    public static String validateMajor(Scanner sc){
               return InputMethod.inputString(sc,"Nhập ngành học","Ngành học không được để trống");
    }

    public static String validateClassName(Scanner sc){
               return InputMethod.inputString(sc,"Nhập tên lớp học","Tên lớp học không được để trống");
    }


    public static float validateGpa (Scanner sc){
        while(true){
            float gpa = InputMethod.inputFloat(sc,"Nhap điểm tích lũy trung bình", "điểm tích lũy trung bình phai la so");;
            if(gpa >= 0 ){
                return gpa;
            }
            System.err.println("Điểm tích luy trung bình phải lon hon hoac bang 0 ");
        }
    }




}
