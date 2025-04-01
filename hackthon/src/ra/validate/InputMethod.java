package ra.validate;

import java.util.Scanner;

public class InputMethod {
    public static String inputString(Scanner sc , String title, String err){
        while(true){
            System.out.println(title);
            String input = sc.nextLine();
            if(!input.isBlank()) return input;
            System.err.println(err);
        }
    }
    public static float inputFloat(Scanner sc , String title, String err){
        while(true){
            System.out.println(title);
            if(!sc.hasNextFloat()){
                System.err.println(err);
                sc.nextLine();
                continue;
            }
            return Float.parseFloat(sc.nextLine());

        }
    }
    public static byte inputByte(Scanner sc , String title, String err){
        while(true){
            System.out.println(title);
            if(!sc.hasNextByte()){
                System.err.println(err);
                sc.nextLine();
                continue;
            }

            return Byte.parseByte(sc.nextLine());
        }
    }
        public static boolean  inputBoolean(Scanner sc , String title, String err){
        while(true){
            System.out.println(title);
            String input = sc.nextLine();
            if( input.equalsIgnoreCase("true")|| input.equalsIgnoreCase("false")){
                return input.equalsIgnoreCase("true");
            }
            System.err.println(err);

        }
    }


}
