// File Path: E:\java_sem2\Inovetive_Assingment\data\COUSTOMER(Path we used in our program)
// Package: bus_pack


// import bus_pack.*;
import java.time.LocalDate;
import java.util.*;
// import java.util.Formatter;
// import java.lang.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;

//---------------------------------ABSTRACT BUS------------------------
abstract class BUS {
    int total_seat;
    public int tkt_price;
    public static int booked_seat = 0;
    public String unicd;
    public String route;

    BUS(String s1, String s2, int a) {
        unicd = s1;
        route = s2;
        tkt_price = a;

    }

    public abstract void display_current_seats();

    public abstract int book_seat(int seat_no);
}

//-------------------------------SEATER BUS-------------------------

class Seater_bus extends BUS {
    // public int total_seat = 40;
    int bst[] = new int[40];
    // variable of super class
    // public int tkt_price;
    // public static int booked_seat = 0;
    // public String unicd;
    // public String route;
    Scanner sc = new Scanner(System.in);

    public Seater_bus(int price, String unicd1, String route1) {
        super(unicd1, route1, price);

        total_seat = 40;

    }

    public int book_seat(int x) {
        for (int i = 0; i < total_seat; i++) {
            if (x == bst[i]) {
                System.out.println("Please enter again this seat is already booked enter again");
                int a1 = sc.nextInt();

                return book_seat(a1);
            }
        }
        bst[booked_seat] = x;
        booked_seat++;
        return x;
    }

    public void display_current_seats() {

        System.out.println("\n\n");
        System.out.println("\n============================================================================");
        System.out.println("||                        DRIVER                                          ||");
        System.out.println("||                               AREA                                     ||");
        System.out.println("============================================================================");
        int stn = 0, stn1 = 0;
        for (int i = 0; i < 10; i++) {
            int s1 = 0;
            // System.out.println("");
            System.out.print("\t\t\t");
            for (int d = 0; d < 4; d++) {
                ++stn1;
                for (int j = 0; j <= booked_seat; j++) {
                    if (stn1 == bst[j]) {
                        s1++;
                        break;
                    }
                }
                if (s1 != 0) {
                    System.out.print("O ");
                    s1 = 0;
                } else {
                    System.out.print("X ");
                }
                if (d == 1) {
                    System.out.print("\t\t");
                }
                if (d == 0 || d == 2) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n\t\t\t");
            for (int d = 0; d < 4; d++) {
                System.out.print(++stn);
                if (d == 1) {
                    System.out.print("\t\t");
                }
                if (d == 0 || d == 2) {
                    System.out.print(" ");
                }
            }
            System.out.println("\n");

        }
    }
}

//------------------------------------SLEEPER BUS-----------------------------------

class Sleeper_Bus extends BUS {
    Scanner sc = new Scanner(System.in);
    // int total_seat;
    int bst[] = new int[30];

    // variable of super class
    // int tkt_price;
    // static int booked_seat =0;
    // String unicd;
    // String route;
    public Sleeper_Bus(int price, String unicd1, String route1) {
        super(unicd1, route1, price);
        total_seat = 30;

    }

    public int book_seat(int x) {
        for (int i = 0; i < total_seat; i++) {
            if (x == bst[i]) {
                System.out.println("Please enter again this seat is already booked enter again");
                int a1 = sc.nextInt();
                book_seat(a1);
                return book_seat(a1);
            }
        }

        bst[booked_seat] = x;
        booked_seat++;
        return x;
    }

    public void display_current_seats() {
        System.out.println("\n\n");
        System.out.println("\n============================================================================");
        System.out.println("||                        DRIVER                                          ||");
        System.out.println("||                               AREA                                     ||");
        System.out.println("============================================================================");
        int stn = 0, stn1 = 0;
        for (int i = 0; i < 10; i++) {

            System.out.print("\t\t\t");
            int s1 = 0;

            for (int d = 0; d < 3; d++) {
                ++stn1;
                for (int j = 0; j <= booked_seat; j++) {
                    if (stn1 == bst[j]) {
                        s1++;
                        break;
                    }
                }
                if (s1 != 0) {
                    System.out.print("O ");
                    s1 = 0;
                } else {
                    System.out.print("X ");
                }
                if (d == 0) {
                    System.out.print("\t\t");
                }
                if (d == 1) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n\t\t\t");
            for (int d = 0; d < 3; d++) {
                System.out.print(++stn);
                if (d == 0) {
                    System.out.print("\t\t");
                }
                if (d == 1) {
                    System.out.print(" ");
                }

            }
            System.out.println("\n");

        }
    }
}

//---------------------------------GSS ARRAY OF BUS------------------------------

class Bus_Array {

    private BUS arr[];
    private int count;

    public Bus_Array(int length) {
        arr = new BUS[length];
    }

    public void print_table() {

        int cnte = 1;

        System.out.println("============================================================================");
        System.out.println("\t\t\t BUS TIME TABLE");
        System.out.println("============================================================================");
        System.out.println("No.  | Code        | Route                     | Price     | Available seats");
        System.out.println("============================================================================");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5s| %-12s| %-26s| %-10s| %-15s", cnte, arr[i].unicd, arr[i].route, arr[i].tkt_price,
                    (arr[i].total_seat - arr[i].booked_seat));
            System.out.println("\n----------------------------------------------------------------------------");
            cnte++;
        }
    }

    public void insert(BUS ob) {

        if (arr.length == count) {

            BUS newArr[] = new BUS[2 * count];

            for (int i = 0; i < count; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }

        arr[count++] = ob;
    }

    public BUS find(int x) {

        return arr[--x];

    }
}


//--------------------------------------COUSTMER-----------------------------


class coustmer {
    LocalDate date = LocalDate.now();

    String name;
    String phone_no;
    int booked_tktc = 0;
    int seat_no[] = new int[40];
    public BUS B;

    public coustmer(BUS b2, String s1, String s2) {
        B = b2;
        name = s1;
        phone_no = s2;
    }

    public void booking(int x) {
        seat_no[booked_tktc++] = x;
    }

    public int count_bill() {
        int bill = B.tkt_price * booked_tktc;
        return bill;
    }

    public void show_bill() {
        System.out.print("============================================================================");
        System.out.printf("\n||\t\t\t Name: %-43s||", name);
        System.out.printf("\n||\t\t\t Contact number: %-33s||", phone_no);
        System.out.printf("\n||\t\t\t Bus code: %-39s||", B.unicd);
        System.out.printf("\n||\t\t\t Route: %-42s||", B.route);
        System.out.printf("\n||\t\t\t Date: %-43s||", date);
        System.out.printf("\n||\t\t\t total booked seat: %-30s||", booked_tktc);
        for (int i = 1; i <= booked_tktc; i++) {
            System.out.printf("\n||\t\t\t Seat number " + i + " is : %-30s||", seat_no[i]);
        }
        System.out.println("\n============================================================================");
        System.out.println("||                       THANK YOU                                        ||");
        System.out.println("||         For more information Contact XYZ travels                       ||");
        System.out.println("============================================================================");
    }

    public void print_bill() {
        try {
            FileWriter fwrite = new FileWriter(
                    "E:\\java_sem2\\Inovetive_Assingment\\data\\COUSTOMER\\" + name + ".txt");

            fwrite.write("\n============================================================================");
            fwrite.write("\n\t\t\t Name: " + name);
            fwrite.write("\n\t\t\t Contact number: " + phone_no);
            fwrite.write("\n\t\t\t Bus code : " + B.unicd);
            fwrite.write("\n\t\t\t Route : " + B.route);
            fwrite.write("\n\t\t\t Date : " + date);
            fwrite.write("\n\t\t\t total booked seat: " + booked_tktc);
            for (int i = 1; i <= booked_tktc; i++) {
                fwrite.write("\n\t\t\t Seat numbe " + i + " is :" + seat_no[i]);
            }
            fwrite.write("\n============================================================================");
            fwrite.write("\n\t\t\t\t THANK YOU");
            fwrite.write("\n\t\t\t For more information Contact XYZ travels  ");
            fwrite.write("\n============================================================================");

            fwrite.close();
            System.out.println("Ticket printed Successfully.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

}

//-----------------------------------MAIN--------------------------------------------------------------

public class main {
    public static void Loading() {
        for (int i = 0; i < 101; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\n\n\n\n\t\t\t\t Loading" + i + "%");
            for (int j = 0; j < i / 2; j++) {
                System.out.print("\u2588");
            }
            for (int x = 0; x < 999999 + 1; x++) {
                System.out.print("");
            }
        }
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        Scanner sc = new Scanner(System.in);

        Bus_Array bsarry = new Bus_Array(30);
        //INITIALIZE THE TIMTABLE

        
        Seater_bus s1 = new Seater_bus(300, "st1234", "Rajkot-Chotila-Ahmedabad");
        bsarry.insert(s1);
        Seater_bus s2 = new Seater_bus(320, "st1244", "Rajkot-Sr.Nagar-Ahmedabad");
        bsarry.insert(s2);
        Seater_bus s3 = new Seater_bus(350, "st1234", "Rajkot-Bhavngar-Ahmedabad");
        bsarry.insert(s3);
        Seater_bus s4 = new Seater_bus(600, "st1235", "Rajkot-Ahmedabad-Surat");
        bsarry.insert(s4);
        Seater_bus s5 = new Seater_bus(360, "st5234", "Rajkot-Ahmedabad");
        bsarry.insert(s5);
        Seater_bus s6 = new Seater_bus(380, "st1234", "Rajkot-Mahesana");
        bsarry.insert(s6);
        Seater_bus s7 = new Seater_bus(300, "st1234", "Rajkot-Chotila-Ahmedabad");
        bsarry.insert(s7);
        Seater_bus s9 = new Seater_bus(200, "st1264", "Rajkot-Chotila");
        bsarry.insert(s9);
        Seater_bus s8 = new Seater_bus(250, "st1245", "Rajkot-Junagdh");
        bsarry.insert(s8);
        Seater_bus s10 = new Seater_bus(350, "st2345", "Rajkot-Dwarka");
        bsarry.insert(s10);

        Sleeper_Bus ss1 = new Sleeper_Bus(300 + 200, "sp1234", "Rajkot-Chotila-Ahmedabad");
        bsarry.insert(ss1);
        Sleeper_Bus ss2 = new Sleeper_Bus(320 + 200, "sp1244", "Rajkot-Sr.nagar-Ahmedabad");
        bsarry.insert(ss2);
        Sleeper_Bus ss3 = new Sleeper_Bus(350 + 200, "sp1234", "Rajkot-Bhavngar-Ahmedabad");
        bsarry.insert(ss3);
        Sleeper_Bus ss4 = new Sleeper_Bus(600 + 200, "sp1235", "Rajkot-Ahmedabad-Surat");
        bsarry.insert(ss4);
        Sleeper_Bus ss5 = new Sleeper_Bus(360 + 200, "sp5234", "Rajkot-Ahmedabad");
        bsarry.insert(ss5);
        Sleeper_Bus ss6 = new Sleeper_Bus(380 + 200, "sp1234", "Rajkot-Mahesana");
        bsarry.insert(ss6);
        Sleeper_Bus ss7 = new Sleeper_Bus(300 + 200, "sp1234", "Rajkot-Chotila-Ahmedabad");
        bsarry.insert(ss7);
        Sleeper_Bus ss9 = new Sleeper_Bus(200 + 100, "sp1234", "Rajkot-Chotila");
        bsarry.insert(ss9);
        Sleeper_Bus ss8 = new Sleeper_Bus(250 + 100, "sp1239", "Rajkot-Junagdh");
        bsarry.insert(ss8);
        Sleeper_Bus ss10 = new Sleeper_Bus(350 + 100, "sp2344", "Rajkot-Dwarka");
        bsarry.insert(ss10);

        // bsarry.print_table();
        System.out.println("\t Are you New user(y/n) : ");
        char f = sc.next().charAt(0);
        if (f == 'y') {

            String s11, s22;
            System.out.println("\n\t Create login id : ");
            sc.nextLine();
            s11 = sc.nextLine();
            System.out.println("\n\t Create Password : ");
            s22 = sc.nextLine();
            admin a = new admin(s22, s11);
            a.Store_password();
        }

        while (true) {

            Loading();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("\n============================================================================\n");
            System.out.print("\n                    WELCOME XYZ TRAVELS                                     \n");
            System.out.print("\n============================================================================\n");
            System.out.print("\n                  [1] Admin login\n");
            System.out.print("\n                  [2] Customer login\n");
            System.out.print("\n                  [3] View bus time table\n");
            System.out.print("\n                  [4] Exit\n");
            System.out.print("\n============================================================================\n");
            System.out.print("\n        Enter your choice : ");
            int d1;
            d1 = sc.nextInt();
            if (d1 == 1) {
                System.out.println("\n\t Enter login id : ");
                sc.nextLine();
                String s111 = sc.nextLine();
                System.out.println("\n\t Enter Password : ");

                String s222 = sc.nextLine();
                String filedata = "";
                try {
                    // Create f1 object of the file to read data
                    File f1 = new File("E:\\java_sem2\\Inovetive_Assingment\\data\\admin\\" + s111 + ".txt");

                    Scanner dataReader = new Scanner(f1);
                    while (dataReader.hasNextLine()) {
                        String fileData = dataReader.nextLine();
                        // System.out.println(fileData);
                        filedata = filedata + fileData;
                    }
                    dataReader.close();
                } catch (FileNotFoundException exception) {
                    System.out.println("Unexcpected error occurred!");
                    exception.printStackTrace();
                }

                if (s222.equals(filedata)) {
                    while (true) {
                        Loading();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print(
                                "\n============================================================================\n");
                        System.out.print(
                                "\n                    WELCOME XYZ TRAVELS                                     \n");
                        System.out.print(
                                "\n============================================================================\n");
                        System.out.print("\n                  [1] Create new Admin\n");
                        System.out.print("\n                  [2] Add new bus\n");
                        System.out.print("\n                  [3] View bus time table\n");
                        System.out.print("\n                  [4] Get details of bus\n");
                        System.out.print("\n                  [5] Exit\n");
                        System.out.print(
                                "\n============================================================================\n");
                        int xy;
                        System.out.print("\n        Enter your choice : ");
                        xy = sc.nextInt();
                        if (xy == 2) {

                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.print(
                                    "\n============================================================================\n");
                            System.out.print("\n                  [1] Create new seater bus\n");
                            System.out.print("\n                  [2] Create new Sleeper bus\n");
                            System.out.print(
                                    "\n============================================================================\n");
                            int xy1;
                            System.out.print("\n        Enter your choice : ");
                            xy1 = sc.nextInt();
                            if (xy1 == 1) {

                                String st, st1;
                                int pr;

                                System.out.println("\n  Enter route of bus : ");
                                sc.nextLine();
                                st = sc.nextLine();
                                System.out.println("\n  Enter Code : ");
                                st1 = sc.nextLine();
                                System.out.println("\n  Enter price of ticket : ");
                                pr = sc.nextInt();
                                Seater_bus xc = new Seater_bus(pr, st1, st);
                                bsarry.insert(xc);

                            }
                            if (xy1 == 2) {

                                String st, st1;
                                int pr;

                                System.out.println("\n  Enter route of bus : ");
                                sc.nextLine();
                                st = sc.nextLine();
                                System.out.println("\n  Enter Code : ");
                                st1 = sc.nextLine();
                                System.out.println("\n  Enter price of ticket : ");
                                pr = sc.nextInt();
                                Sleeper_Bus xc = new Sleeper_Bus(pr, st1, st);
                                bsarry.insert(xc);

                            }
                            System.out.println("Added Successfully press any queue to continue...");
                            sc.next().charAt(0);
                            continue;

                        }
                        if (xy == 1) {

                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            String s11, s22;
                            System.out.println("\n\t Create login id : ");
                            sc.nextLine();
                            s11 = sc.nextLine();
                            System.out.println("\n\t Create Password : ");
                            s22 = sc.nextLine();
                            admin a = new admin(s22, s11);
                            a.Store_password();
                            System.out.println("Created Successfully press any queue to continue...");
                            sc.next().charAt(0);
                            continue;

                        }
                        if (xy == 3) {

                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            bsarry.print_table();
                            System.out.println(" press any queue to continue...");
                            sc.next().charAt(0);
                            continue;

                        }
                        if (xy == 4) {

                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            int bs;
                            System.out.println("\n  Enter index of bus : ");
                            bs = sc.nextInt();
                            BUS b = bsarry.find(bs);
                            System.out.println("\n Code of Bus :" + b.unicd);
                            System.out.println("\n route of Bus :" + b.route);
                            System.out.println("\n Price of Bus :" + b.tkt_price);
                            b.display_current_seats();
                            System.out.println(" press any queue to continue...");
                            sc.next().charAt(0);
                            continue;
                        }
                        if (xy == 5) {
                            break;
                        }

                    }
                } else {
                    System.out.println("Password is wrong press any queue to continue...");
                    sc.next().charAt(0);

                    // continue;

                }

            }
            if (d1 == 2) {

                while (true) {
                    Loading();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out
                            .print("\n============================================================================\n");
                    System.out
                            .print("\n                    WELCOME XYZ TRAVELS                                     \n");
                    System.out
                            .print("\n============================================================================\n");
                    System.out.print("\n                  [1] Book bus\n");
                    System.out.print("\n                  [2] View bus time table\n");
                    System.out.print("\n                  [3] Exit\n");
                    System.out
                            .print("\n============================================================================\n");
                    int xy2;
                    System.out.print("\n        Enter your choice : ");
                    xy2 = sc.nextInt();
                    if (xy2 == 1) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\n  Enter your name : ");
                        sc.nextLine();
                        String st = sc.nextLine();
                        System.out.println("\n  Enter your Contact no. : ");
                        String st1 = sc.nextLine();
                        bsarry.print_table();
                        int xy4;
                        System.out.print("\n        Enter your choice : ");
                        xy4 = sc.nextInt();
                        BUS b = bsarry.find(xy4);

                        int xy6;
                        System.out.print("\n        Enter how many seats you want to book : ");
                        xy6 = sc.nextInt();
                        coustmer c = new coustmer(b, st, st1);
                        if (xy6 > b.total_seat - b.booked_seat) {
                            System.out.print("\n        You can not book more than available seats ");
                            continue;
                        }

                        else {
                            System.out.print(
                                    "\n============================================================================\n");
                            b.display_current_seats();
                            System.out.print(
                                    "\n============================================================================\n");
                            for (int i = 0; i < xy6; i++) {
                                System.out.print("\n        Enter seat no.: ");
                                int seat_no = sc.nextInt();
                                b.book_seat(seat_no);
                                c.booking(seat_no);

                            }
                            System.out.print(
                                    "\n============================================================================\n");

                            int bill = c.count_bill();
                            System.out.println("\n\t Your bill is  " + bill);
                            System.out.println("\n\t Enter your Card number:  ");
                            int card = sc.nextInt();
                            Random rg = new Random();
                            int otp = rg.nextInt(9999);
                            System.out.println("");
                            System.out.printf("\t OTP is %4s", otp);
                            System.out.println("\n\t Enter OTP:  ");
                            while (true) {
                                int otp1;
                                otp1 = sc.nextInt();
                                if (otp1 == otp) {
                                    break;
                                } else {
                                    System.out.println("\n\t Please enter correct otp:  ");

                                }
                            }
                            System.out.print(
                                    "\n============================================================================\n");
                            c.show_bill();
                            c.print_bill();
                            System.out.print("\t Your booking is done successfully ");

                        }

                        System.out.println(" press any queue to continue...");
                        sc.next().charAt(0);
                        continue;

                    }
                    if (xy2 == 2) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        bsarry.print_table();
                        System.out.println(" press any queue to continue...");
                        sc.next().charAt(0);
                        continue;
                    }
                    if (xy2 == 3) {

                        break;
                    }

                }
            }
            if (d1 == 3) {

                System.out.print("\033[H\033[2J");
                System.out.flush();
                bsarry.print_table();
                System.out.println(" press any queue to continue...");
                sc.next().charAt(0);
                continue;

            }
            if (d1 == 4) {
                break;
            }

        }

    }
}
