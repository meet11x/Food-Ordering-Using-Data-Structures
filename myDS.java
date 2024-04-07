import java.util.Calendar;
import java.util.Scanner;

class OnlineFoodOrder {
    static RegisterLL rll = new RegisterLL();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeData();
        System.out.println("\t\t\t\t      -------------------------------------------------");
        System.out.println("\t\t\t\t      |    ======================================     |");
        System.out.println("\t\t\t\t      |    ||      Welcome to FOOD ZONE!!      ||     |");
        System.out.println("\t\t\t\t      |    ======================================     |");
        System.out.println("\t\t\t\t      -------------------------------------------------");

        int loginregisterchoice;
        // for(;;)
        // {
        do {
            System.out.println();
            System.out.println("Your Choices : ");
            System.out.println();
            System.out.println("                                                                 < 1 > to Register");
            System.out.println("                                                                 < 2 > to Login");
            System.out.println("                                                                 < 3 > to Exit");
            System.out.println();
            // System.out.println("Enter 3 to Delete Your Account");
            System.out.print("                                                                   Enter Your Choice : ");
            loginregisterchoice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (loginregisterchoice) {
                case 1: {
                    System.out.println();
                    System.out.print("Enter Your Name : ");
                    String name = sc.nextLine();
                    System.out.println();
                    boolean flag = false;
                    long mobilenum;
                    do {
                        System.out.print("Enter Your Mobile Number :");
                        mobilenum = sc.nextLong();
                        sc.nextLine();
                        String phoneno = String.valueOf(mobilenum);
                        if (phoneno.length() == 10) {
                            for (int j = 0; j < phoneno.length(); j++) {
                                if (phoneno.charAt(j) >= '0' && phoneno.charAt(j) <= '9') {
                                    flag = true;
                                    System.out.println("Done...");
                                    break;
                                } else {
                                    System.out.println();
                                    System.out.println(
                                            "                                                                   Invalid Format OF MobileNO :");
                                    System.out.println(
                                            "                                                                   Enter Again :");
                                    System.out.println();
                                    flag = false;
                                }
                            }
                        } else {
                            System.out.println();
                            System.out.println("Invalid Format OF MobileNO :");
                            System.out.print("Enter Again :");
                            flag = false;
                        }
                    } while (flag == false);
                    System.out.println();
                    String password;
                    for (;;) {
                        System.out.println();
                        System.out.print("Set Your Password :");
                        password = sc.nextLine();
                        if (password.length() >= 8) {
                            break;
                        } else {
                            System.out.println("             --> Password length should be greater than or equal to 8");
                        }
                    }
                    Register reg = new Register(name, mobilenum, password);
                    rll.insertAtLast(reg);
                }
                case 2: {
                    System.out.println();
                    System.out.println("                         ------------------");
                    System.out.println("                         Login Your Account");
                    System.out.println("                         ------------------");
                    System.out.println();
                    for (int i = 1; i <= 3; i++) {
                        System.out.print("Enter Your Mobile Number : ");
                        long mno = sc.nextLong();
                        System.out.println();
                        System.out.print("Enter Your Password : ");
                        sc.nextLine();
                        String password = sc.nextLine();
                        System.out.println();
                        boolean check = rll.isThere(mno, password);
                        if (check) {
                            System.out.println();
                            System.out.println("                         ---------------------------");
                            System.out.println("                         SuccessFully Log in Done...");
                            System.out.println("                         ---------------------------");
                            System.out.println();
                            manage(mno);
                            break;
                        } else {
                            System.out.println(
                                    "                         --> Entered Mobile Number or Password is Invalid");
                            System.out.println();
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("                         ---------");
                    System.out.println("                         THANK YOU");
                    System.out.println("                         ---------");
                    System.out.println();
                    break;
                }
                default: {
                    System.out.println();
                    System.out.print("            --> Enter Valid Choice : ");
                    System.out.println();
                    break;
                }
            }
        } while (loginregisterchoice != 3);
        /*
         * if(loginregisterchoice==1)
         * {
         * 
         * break;
         * }
         * else if(loginregisterchoice==2)
         * {
         * System.out.print("Enter Your Name : ");
         * sc.nextLine();
         * String name=sc.nextLine();
         * System.out.print("Enter Your Mobile Number :");
         * long mobilenum=sc.nextLong();
         * sc.nextLine();
         * String password;
         * for(;;)
         * {
         * System.out.print("Set Your Password :");
         * password=sc.nextLine();
         * if(password.length()>=8)
         * {
         * break;
         * }
         * else
         * {
         * System.out.println("Password length should be greater than or equal to 8");
         * }
         * }
         * Register reg=new Register(name, mobilenum, password);
         * rll.insertAtLast(reg);
         * break;
         * }
         */
        /*
         * else if(loginregisterchoice==3)
         * {
         * System.out.print("Enter Your Mobile Number :");
         * long mobilenum=sc.nextLong();
         * System.out.print("Enter Your Password : ");
         * String password=sc.nextLine();
         * rll.deletePerticularValue(mobilenum, password);
         * break;
         * }
         */
        /*
         * else
         * {
         * System.out.print("Enter Valid Choice : ");
         * }
         */
        // }
    }

    static void initializeData() {
        Register reg = new Register("Prince", 6352451341l, "Prince123");
        rll.insertAtLast(reg);
    }

    static String[] menu = { "Pizza", "Burger", "Sandwich", "Thali", "Biryani",
            "Cake", "Chicken", "Rolls", "Dosa", "Panner", "Paratha",
            "Noodles" }; // add various thali like gujarati, punjabi etc.
    static String[] pizza = { "Cheezy-7 Pizza", "Margherita Pizza", "Double Cheese Margherita Pizza ",
            "Sweet Corns Pizza",
            "Farm Villa Pizza", "Panner Tikka Butter Masala Pizza", "Tandoori Panner Pizza" };
    static double[] pizzaPrice = { 255.00, 150.00, 190.00, 100.00, 195.00, 255.00, 255.00 };
    static String[] cake = { "Cassata Cake", "Oreo Chocolate Cake", "Pineapple Cake", "Chocolate Truffle Cake",
            "Black Forest Cake", "Eggless Kitkat Oreo Cake", "Eggless Chocolate Light Cake" };
    static double[] cakePrice = { 250.00, 295.00, 240.00, 350.00, 270.00, 350.00, 280.00 };
    static String[] burger = { "McSpicy Premium Veg Burger", "Chicken Big Mac Burger", "McVeggie Burger",
            " Veg Maharaja Burger", "McAloo Tikki Burger", "Corn & Cheese Burger", "Mexican McAloo Tikki Burger" };
    static double[] burgerPrice = { 249.00, 235.00, 145.00, 220.00, 58.00, 145.00, 100.00 };
    static String[] sandwich = { "Grilled Cheese sandwich", "Nutella Sandwich", "Olive Sandwich", "Vegetable Sandwich",
            "Bread Sandwich", "Bombay Roadside Sandwich", "Pesto Caprese Grilled Cheese Sandwich" };
    static double[] sandwichPrice = { 120.00, 150.00, 200.00, 119.00, 200.00, 350.00, 350.00 };
    static String[] thali = { "Veg Jaipuri Thali", "Veg Kolhapuri Thali", "Mix Veg Thali", "Sev Tomato Thali",
            "Paneer Lawabdar Thali", "Panner Tikka Thali", "Paneer Jaipuri Thali" };
    static double[] thaliPrice = { 279.00, 279.00, 279.00, 279.00, 279.00, 279.00, 279.00 };
    static String[] biryani = { "Chicken Biryani(Bone)", "Chicken Dum Hyderabadi Biryani", "Veg Dum Biryani",
            "Panner Dum Biryani", "Boneless Chicken Biryani", "Veg Biryani", "Chicken Dum Nawabi Biryani" };
    static double[] biryaniPrice = { 299.00, 399.00, 299.00, 319.00, 319.00, 399.00, 419.00 };
    static String[] chicken = { "Chicken Lollipop", "Tandoori Chicken", "Deshi Style chicken", "Chicken Masala",
            "Chicken Rara", "Butter Chicken Bone", "Chicken Tikka" };
    static double[] chickenPrice = { 279.00, 199.00, 369.00, 369.00, 389.00, 399.00, 399.00 };
    static String[] rolls = { "Tandoori Panner Frankie", "Hl Special Panner Frankie", "Manchurian Noodles Frankie",
            "Hl Special Chinese Frankie", "Vegetable Frankie", "Spicy Peri Peri Cheese Frankie",
            "Panner Manchurian Frankie" };
    static double[] rollsPrice = { 169.00, 179.00, 139.00, 159.00, 109.00, 169.00, 149.00 };
    static String[] panner = { "Cheese Butter Masala", "Panner Tawa Masala", "Panner Tikka Masala", "Panner Kadai",
            "Panner Chilly", "Manchurian Special Panner", "Palak Panner" };
    static double[] pannerPrice = { 280.00, 280.00, 280.00, 280.00, 260.00, 295.00, 265.00 };
    static String[] dosa = { "Masala Dosa", "Mysore Special Dosa", "Rava Plain Dosa", "Rava Masala Dosa",
            "Gwalia Cheese Dosa",
            "Spring Cheese Dosa", " Plain Cheese Dosa" };
    static double[] dosaPrice = { 80.00, 170.00, 100.00, 110.00, 120.00, 150.00, 90.00 };
    static String[] paratha = { "Aloo Paratha", "Stuffed Paratha", "Panner Paratha", "Butter Paratha", "Methi Paratha",
            "Amritsari Paratha", "All In One Cheese Paratha" };
    static double[] parathaPrice = { 150.00, 130.00, 160.00, 65.00, 85.00, 285.00, 305.00 };
    static String[] noodle = { "Veg Hakka Noodles", "Pad Thai Noodles", "Veg Schezwan Noodles", "Manchurian Noodles",
            "Chicken Singpore Noodles", " Chicken Tikka Noodles", "Mirza Special Noodles" };
    static double[] noodlePrice = { 229.00, 259.00, 249.00, 239.00, 369.00, 349.00, 259.00 };
    static OrderLL oll;

    static void printMenu() {
        for (int j = 0; j < menu.length; j++) {
            System.out.println("\t\t  ===============================================");
            System.out.println("\t\t | " + menu[j] + ":                " + " ");
            if (j == 0) {
                for (int i = 0; i < pizza.length; i++) {
                    System.out.println("\t\t | " + pizza[i] + "    $ " + pizzaPrice[i] + "      ");
                }
            }
            if (j == 1) {
                for (int i = 0; i < burger.length; i++) {
                    System.out.println("\t\t | " + burger[i] + "    $ " + burgerPrice[i] + "      ");
                }
            }
            if (j == 2) {
                for (int i = 0; i < sandwich.length; i++) {
                    System.out.println("\t\t | " + sandwich[i] + "    $ " + sandwichPrice[i] + "      ");
                }
            }
            if (j == 3) {
                for (int i = 0; i < thali.length; i++) {
                    System.out.println("\t\t | " + thali[i] + "    $ " + thaliPrice[i] + "      ");
                }
            }
            if (j == 4) {
                for (int i = 0; i < biryani.length; i++) {
                    System.out.println("\t\t | " + biryani[i] + "    $ " + biryaniPrice[i] + "      ");
                }
            }
            if (j == 5) {
                for (int i = 0; i < cake.length; i++) {
                    System.out.println("\t\t | " + cake[i] + "    $ " + cakePrice[i] + "      ");
                }
            }
            if (j == 6) {
                for (int i = 0; i < chicken.length; i++) {
                    System.out.println("\t\t | " + chicken[i] + "    $ " + chickenPrice[i] + "      ");
                }
            }
            if (j == 7) {
                for (int i = 0; i < rolls.length; i++) {
                    System.out.println("\t\t | " + rolls[i] + "    $ " + rollsPrice[i] + "      ");
                }
            }
            if (j == 8) {
                for (int i = 0; i < dosa.length; i++) {
                    System.out.println("\t\t | " + dosa[i] + "    $ " + dosaPrice[i] + "      ");
                }
            }
            if (j == 9) {
                for (int i = 0; i < panner.length; i++) {
                    System.out.println("\t\t | " + panner[i] + "    $ " + pannerPrice[i] + "      ");
                }
            }
            if (j == 10) {
                for (int i = 0; i < paratha.length; i++) {
                    System.out.println("\t\t | " + paratha[i] + "    $ " + parathaPrice[i] + "      ");
                }
            }
            if (j == 11) {
                for (int i = 0; i < noodle.length; i++) {
                    System.out.println("\t\t | " + noodle[i] + "    $ " + noodlePrice[i] + "      ");
                }
            }
            System.out.println("\t\t  ===============================================");
        }
        System.out.println("\t\t  ===============================================");

    }

    static void manage(long mno) {
        Scanner sc = new Scanner(System.in);
        oll = new OrderLL();
        double sum = 0;
        /*
         * String[] menu = { " Pizza     ,", " Burger    ,", " Sandwich  ,",
         * " Thali     ,", " Biryani   ,",
         * " Cake     , ", " Chicken   ,", " Rolls     ,", " Dosa      ,",
         * "Panner    ,", "Paratha   ,",
         * " Noodles   " }; // add various thali like gujarati, punjabi etc.
         */
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("What do you want to eat : ");
        System.out.println("--------------------------");
        System.out.println();
        printMenu();
        /*
         * String[] pizza = { "Cheezy-7 Pizza", "Margherita Pizza",
         * "Double Cheese Margherita Pizza ", "Sweet Corns Pizza",
         * "Farm Villa Pizza", "Panner Tikka Butter Masala Pizza",
         * "Tandoori Panner Pizza" };
         * double[] pizzaPrice = { 255.00, 150.00, 190.00, 100.00, 195.00, 255.00,
         * 255.00 };
         * String[] cake = { "Cassata Cake", "Oreo Chocolate Cake", "Pineapple Cake",
         * "Chocolate Truffle Cake",
         * "Black Forest Cake", "Eggless Kitkat Oreo Cake",
         * "Eggless Chocolate Light Cake" };
         * double[] cakePrice = { 250.00, 295.00, 240.00, 350.00, 270.00, 350.00, 280.00
         * };
         * String[] burger = { "McSpicy Premium Veg Burger", "Chicken Big Mac Burger",
         * "McVeggie Burger",
         * " Veg Maharaja Burger", "McAloo Tikki Burger", "Corn & Cheese Burger",
         * "Mexican McAloo Tikki Burger" };
         * double[] burgerPrice = { 249.00, 235.00, 145.00, 220.00, 58.00, 145.00,
         * 100.00 };
         * String[] sandwich = { "Grilled Cheese sandwich", "Nutella Sandwich",
         * "Olive Sandwich", "Vegetable Sandwich",
         * "Bread Sandwich", "Bombay Roadside Sandwich",
         * "Pesto Caprese Grilled Cheese Sandwich" };
         * double[] sandwichPrice = { 120.00, 150.00, 200.00, 119.00, 200.00, 350.00,
         * 350.00 };
         * String[] thali = { "Veg Jaipuri Thali", "Veg Kolhapuri Thali",
         * "Mix Veg Thali", "Sev Tomato Thali",
         * "Paneer Lawabdar Thali", "Panner Tikka Thali", "Paneer Jaipuri Thali" };
         * double[] thaliPrice = { 279.00, 279.00, 279.00, 279.00, 279.00, 279.00,
         * 279.00 };
         * String[] biryani = { "Chicken Biryani(Bone)",
         * "Chicken Dum Hyderabadi Biryani", "Veg Dum Biryani",
         * "Panner Dum Biryani", "Boneless Chicken Biryani", "Veg Biryani",
         * "Chicken Dum Nawabi Biryani" };
         * double[] biryaniPrice = { 299.00, 399.00, 299.00, 319.00, 319.00, 399.00,
         * 419.00 };
         * String[] chicken = { "Chicken Lollipop", "Tandoori Chicken",
         * "Deshi Style chicken", "Chicken Masala",
         * "Chicken Rara", "Butter Chicken Bone", "Chicken Tikka" };
         * double[] chickenPrice = { 279.00, 199.00, 369.00, 369.00, 389.00, 399.00,
         * 399.00 };
         * String[] rolls = { "Tandoori Panner Frankie", "Hl Special Panner Frankie",
         * "Manchurian Noodles Frankie",
         * "Hl Special Chinese Frankie", "Vegetable Frankie",
         * "Spicy Peri Peri Cheese Frankie",
         * "Panner Manchurian Frankie" };
         * double[] rollsPrice = { 169.00, 179.00, 139.00, 159.00, 109.00, 169.00,
         * 149.00 };
         * String[] panner = { "Cheese Butter Masala", "Panner Tawa Masala",
         * "Panner Tikka Masala", "Panner Kadai",
         * "Panner Chilly", "Manchurian Special Panner", "Palak Panner" };
         * double[] pannerPrice = { 280.00, 280.00, 280.00, 280.00, 260.00, 295.00,
         * 265.00 };
         * String[] dosa = { "Masala Dosa", "Mysore Special Dosa", "Rava Plain Dosa",
         * "Rava Masala Dosa",
         * "Gwalia Cheese Dosa", "Spring Cheese Dosa", " Plain Cheese Dosa" };
         * double[] dosaPrice = { 80.00, 170.00, 100.00, 110.00, 120.00, 150.00, 90.00
         * };
         * String[] paratha = { "Aloo Paratha", "Stuffed Paratha", "Panner Paratha",
         * "Butter Paratha", "Methi Paratha",
         * "Amritsari Paratha", "All In One Cheese Paratha" };
         * double[] parathaPrice = { 150.00, 130.00, 160.00, 65.00, 85.00, 285.00,
         * 305.00 };
         * String[] noodle = { "Veg Hakka Noodles", "Pad Thai Noodles",
         * "Veg Schezwan Noodles", "Manchurian Noodles",
         * "Chicken Singpore Noodles", " Chicken Tikka Noodles", "Mirza Special Noodles"
         * };
         * double[] noodlePrice = { 229.00, 259.00, 249.00, 239.00, 369.00, 349.00,
         * 259.00 };
         */
        while (true) {
            System.out.print("   Enter Name of Food Item You Want To order : ");
            String foodorder = sc.nextLine();
            System.out.println();
            /*
             * if(foodorder.equalsIgnoreCase("pizza"))
             * {
             * for(int i=0;i<pizza.length;i++)
             * {
             * System.out.println(pizza[i]+" price : "+pizzaPrice[i]);
             * System.out.println("------------------");
             * }
             * System.out.print("What type of pizza do you want to order : ");
             * String fopizza=sc.nextLine();
             * for(int j=0;j<pizza.length;j++)
             * {
             * if(fopizza.equalsIgnoreCase(pizza[j]))
             * {
             * Order o=new Order(mno, pizza[j]);
             * sum=sum+pizzaPrice[j];
             * oll.insertAtLast(o);
             * break;
             * }
             * }
             * }
             */
            if (foodorder.equalsIgnoreCase("pizza") || foodorder.startsWith("pi")) {
                for (int i = 0; i < pizza.length; i++) {
                    System.out.println((i + 1) + ".. " + pizza[i] + " price : " + pizzaPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of PIZZA Type You Want to Order  : ");
                int fopizza = sc.nextInt();
                System.out.println();
                for (int j = 0; j < pizza.length; j++) {
                    if (fopizza == (j + 1)) {
                        Order o = new Order(mno, pizza[j], pizzaPrice[j]);
                        sum = sum + pizzaPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("cake") || foodorder.startsWith("ca")) {
                for (int i = 0; i < cake.length; i++) {
                    System.out.println((i + 1) + ".. " + cake[i] + " price : " + cakePrice[i]);
                    System.out.println("------------------");

                }
                System.out.println();
                System.out.print("Enter No Of Cake Type You Want to Order  : ");
                int focake = sc.nextInt();
                System.out.println();
                for (int j = 0; j < cake.length; j++) {
                    if (focake == (j + 1)) {
                        Order o = new Order(mno, cake[j], cakePrice[j]);
                        sum = sum + cakePrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("burger") || foodorder.startsWith("bu")) {
                for (int i = 0; i < burger.length; i++) {
                    System.out.println((i + 1) + ".. " + burger[i] + " price : " + burgerPrice[i]);
                    System.out.println("------------------");

                }
                System.out.println();
                System.out.print("Enter No Of Burger Type You Want to Order  : ");
                int foburger = sc.nextInt();
                System.out.println();
                for (int j = 0; j < burger.length; j++) {
                    if (foburger == (j + 1)) {
                        Order o = new Order(mno, burger[j], burgerPrice[j]);
                        sum = sum + burgerPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("sandwich") || foodorder.startsWith("sa")) {
                for (int i = 0; i < sandwich.length; i++) {
                    System.out.println((i + 1) + ".. " + sandwich[i] + " price : " + sandwichPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of SandWich Type You Want to Order  : ");
                int fosandwich = sc.nextInt();
                System.out.println();
                for (int j = 0; j < sandwich.length; j++) {
                    if (fosandwich == (j + 1)) {
                        Order o = new Order(mno, sandwich[j], sandwichPrice[j]);
                        sum = sum + sandwichPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("thali") || foodorder.startsWith("th")) {
                for (int i = 0; i < thali.length; i++) {
                    System.out.println((i + 1) + ".. " + thali[i] + " price : " + thaliPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Thali Type You Want to Order  : ");
                int fothali = sc.nextInt();
                System.out.println();
                for (int j = 0; j < thali.length; j++) {
                    if (fothali == (j + 1)) {
                        Order o = new Order(mno, thali[j], thaliPrice[j]);
                        sum = sum + thaliPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("biryani") || foodorder.startsWith("bir")) {
                for (int i = 0; i < biryani.length; i++) {
                    System.out.println((i + 1) + ".. " + biryani[i] + " price : " + biryaniPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Birani Type You Want to Order  : ");
                int fobiryani = sc.nextInt();
                System.out.println();
                for (int j = 0; j < biryani.length; j++) {
                    if (fobiryani == (j + 1)) {
                        Order o = new Order(mno, biryani[j], biryaniPrice[j]);
                        sum = sum + biryaniPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("chicken") || foodorder.startsWith("chi")) {
                for (int i = 0; i < chicken.length; i++) {
                    System.out.println((i + 1) + ".. " + chicken[i] + " price : " + chickenPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Chicken Type You Want to Order  : ");
                int fochicken = sc.nextInt();
                System.out.println();
                for (int j = 0; j < chicken.length; j++) {
                    if (fochicken == (j + 1)) {
                        Order o = new Order(mno, chicken[j], chickenPrice[j]);
                        sum = sum + chickenPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("rolls") || foodorder.startsWith("ro")) {
                for (int i = 0; i < rolls.length; i++) {
                    System.out.println((i + 1) + ".. " + rolls[i] + " price : " + rollsPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Rolls Type You Want to Order  : ");
                int forolls = sc.nextInt();
                System.out.println();
                for (int j = 0; j < rolls.length; j++) {
                    if (forolls == (j + 1)) {
                        Order o = new Order(mno, rolls[j], rollsPrice[j]);
                        sum = sum + rollsPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("panner") || foodorder.startsWith("pan")) {
                for (int i = 0; i < panner.length; i++) {
                    System.out.println((i + 1) + ".. " + panner[i] + " price : " + pannerPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Paneer Type You Want to Order  : ");
                int fopanner = sc.nextInt();
                System.out.println();
                for (int j = 0; j < panner.length; j++) {
                    if (fopanner == (j + 1)) {
                        Order o = new Order(mno, panner[j], pannerPrice[j]);
                        sum = sum + pannerPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("dosa")) {
                for (int i = 0; i < dosa.length; i++) {
                    System.out.println((i + 1) + ".. " + dosa[i] + " price : " + dosaPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Dosa Type You Want to Order  : ");
                int fodosa = sc.nextInt();
                System.out.println();
                for (int j = 0; j < dosa.length; j++) {
                    if (fodosa == (j + 1)) {
                        Order o = new Order(mno, dosa[j], dosaPrice[j]);
                        sum = sum + dosaPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("paratha")) {
                for (int i = 0; i < paratha.length; i++) {
                    System.out.println((i + 1) + ".. " + paratha[i] + " price : " + parathaPrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Paratha Type You Want to Order  : ");
                int foparatha = sc.nextInt();
                System.out.println();
                for (int j = 0; j < burger.length; j++) {
                    if (foparatha == (j + 1)) {
                        Order o = new Order(mno, paratha[j], parathaPrice[j]);
                        sum = sum + parathaPrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else if (foodorder.equalsIgnoreCase("noodle")) {
                for (int i = 0; i < noodle.length; i++) {
                    System.out.println((i + 1) + ".. " + noodle[i] + " price : " + noodlePrice[i]);
                    System.out.println("------------------");
                }
                System.out.println();
                System.out.print("Enter No Of Noodles Type You Want to Order  : ");
                int fonoodle = sc.nextInt();
                System.out.println();
                for (int j = 0; j < noodle.length; j++) {
                    if (fonoodle == (j + 1)) {
                        Order o = new Order(mno, noodle[j], noodlePrice[j]);
                        sum = sum + noodlePrice[j];
                        oll.insertAtLast(o);
                        break;
                    }
                }
            } else {
                System.out.println();
                System.out.println("             PLZ... Enter from the above list");
                System.out.println();
            }
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.print("Do you want to order more Enter yes or No : ");
            // sc.nextLine();
            String yesno;
            boolean exit = false;
            while (true) {
                yesno = sc.nextLine();
                System.out.println("---------------------------------------------");
                if (yesno.equalsIgnoreCase("yes")) {
                    System.out.println();
                    break;
                } else if (yesno.equalsIgnoreCase("no")) {
                    System.out.println();
                    System.out.println("                         ---------");
                    System.out.println("                         THANK YOU");
                    System.out.println("                         ---------");
                    System.out.println();
                    exit = true;
                    break;
                } else {
                    System.out.print("---> Enter yes or no only : ");
                }
            }
            if (exit) {
                System.out.println();
                System.out.println("                         -------------");
                System.out.println("                         Its your cart");
                System.out.println("                         -------------");
                System.out.println();
                oll.display();
                System.out.println("Want to place order (y/n):");
                String confirmOrder = sc.next();
                if (confirmOrder.equalsIgnoreCase("y")) {
                    System.out.println();
                    System.out.println("                       ------------------------");
                    System.out.println("                         Your Bill is : " + sum);
                    System.out.println("                         ----------------------");
                    System.out.println();
                    paymentInterface(sum);
                } else {
                    // ??

                }
                // System.out.println("\nYour Bill is : "+sum+"\n");
                break;
            }
        }

    }

    static void paymentInterface(double totalBill) {
        Payment p = new Payment();
        p.pay(Double.toString(totalBill));
    }

}

class Register {
    String name;
    long mobilenum;
    String password;

    Register(String name, long mobilenum, String password) {
        this.name = name;
        this.mobilenum = mobilenum;
        this.password = password;
    }
}

class Order {
    long mno;
    String food;
    double price;

    Order(long mno, String food, double price) {
        this.mno = mno;
        this.food = food;
        this.price = price;
    }

    /*
     * @Override
     * public String toString() {
     * return "Order [mno=" + mno + ", food=" + food + "]";
     * }
     */
    @Override
    public String toString() {
        return "Order [mno=" + mno + ", food=" + food + ", price=" + price + "]";
    }

}

class RegisterLL {
    class node {
        Register data;
        node next;

        node(Register data) {
            this.data = data;
            this.next = null;
        }
    }

    node first = null;

    void insertAtLast(Register data) {
        node n = new node(data);
        if (first == null) {
            first = n;
        } else {
            node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        System.out.println(n.data.name + " You Register Successfully");
    }

    boolean isThere(long value, String passwordvalue) {
        if (first == null) {
            // System.out.println("No Register");
            return false;
        } else {
            int flag = 0;
            node valuecheck = first;
            do {
                if (valuecheck.data.mobilenum == value && valuecheck.data.password.equals(passwordvalue)) {
                    flag = 1;
                    break;
                }
                valuecheck = valuecheck.next;
            } while (valuecheck != null);
            if (flag == 0) {
                // System.out.println("No Register From Mobile Number "+value+" And Password
                // "+passwordvalue);
                return false;
            } else {
                return true;
            }
        }
    }
    /*
     * void deleteFromFirst()
     * {
     * if(first==null)
     * {
     * System.out.println("No Register");
     * }
     * else
     * {
     * node del=first;
     * first=first.next;
     * del.next=null;
     * }
     * }
     * void deletePerticularValue(long value, String passwordvalue)
     * {
     * if(first==null)
     * {
     * System.out.println("No Register");
     * }
     * else
     * {
     * int flag=0;
     * node valuecheck=first;
     * do
     * {
     * if(valuecheck.data.mobilenum==value &&
     * valuecheck.data.password.equals(passwordvalue))
     * {
     * flag=1;
     * break;
     * }
     * valuecheck=valuecheck.next;
     * }while(valuecheck!=null);
     * if(flag==0)
     * {
     * System.out.println("No Register From Mobile Number "+value+" And Password "
     * +passwordvalue);
     * }
     * else
     * {
     * node temp=first;
     * node del;
     * if(temp.data.mobilenum==value)
     * {
     * del=temp;
     * deleteFromFirst();
     * }
     * else
     * {
     * while(temp.next.data.mobilenum!=value)
     * {
     * temp=temp.next;
     * }
     * del=temp.next;
     * temp.next=del.next;
     * del.next=null;
     * }
     * System.out.println(del.data.name+" Your Account Has Been Removed");
     * }
     * }
     * 
     * }
     */
}

class OrderLL {
    class node1 {
        Order data;
        node1 next;

        node1(Order data) {
            this.data = data;
            this.next = null;
        }
    }

    node1 first = null;

    void insertAtLast(Order data) {
        node1 n = new node1(data);
        if (first == null) {
            first = n;
        } else {
            node1 temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        System.out.println(n.data.food + " is added to your cart");
    }

    void display() {
        if (first == null) {
            System.out.println("no order");
        } else {
            node1 temp = first;
            while (temp != null) {
                System.out.println("                             ITEM -->              " + temp.data.food);
                System.out.println("                             PRICE -->              " + temp.data.price);
                System.out.println();
                temp = temp.next;
            }
        }
    }
}

class Payment {
    static Scanner scan = new Scanner(System.in);

    void pay(String totalBill) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println();
            System.out.println("                         Available mode of Payment: ");
            System.out.println("                      --------------------------------");
            System.out.println("                               1) UPI  ");
            System.out.println("                               2) Credit or debit card:  ");
            System.out.println("                               3) Pay on delivery  ");
            System.out.println();
            System.out.println("Enter your choice: ");
            int payment = scan.nextInt();
            scan.nextLine();
            switch (payment) {
                case 1:
                    boolean isVarified = false;
                    while (true) {
                        System.out.println("Enter upi id: ");
                        String upi = scan.nextLine();
                        isVarified = varifyUPI(upi);
                        if (isVarified) {
                            isVarified = true;
                            break;
                        } else {
                            System.out.println("Invalid upi Id.");
                            System.out.println("Want to try again:(y/n)");
                            String want = scan.nextLine();
                            if (want.equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                    }
                    if (isVarified) {
                        System.out.println("Entered upi id is Correct.");
                        System.out.println("redirecting to app.....");
                        boolean isPaymentDone = paymentAppInterface(totalBill);
                        if (isPaymentDone) {
                            System.out.println("Payment of $" + totalBill + " has been received.");
                            System.out.println("Delivering you Food.");
                            isContinue = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter CardHolder Name");
                    String name = scan.nextLine();
                    System.out.println("Enter card no: ");
                    String cardno = scan.nextLine();
                    if (cardno.length() != 16 || containsAnyLetter(cardno)) {
                        break;
                    }
                    System.out.println("Enter Card expiry date:(MM/YYYY)");
                    String expirydate = scan.nextLine();
                    Boolean isValid = varifyExpiryDate(expirydate);
                    if (!isValid) {
                        System.out.println("Your card is Expired.");
                    } else {
                        System.out.println("redirecting to payments website.....");
                        boolean isPaymentDone = paymentAppInterface(totalBill);
                        if (isPaymentDone) {
                            System.out.println("Payment of $" + totalBill + " has been received.");
                            System.out.println("Delivering you Food.");
                            isContinue = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Payment of $" + totalBill + " to be paid On delivery.");
                    System.out.println("Delivering you Food.");
                    isContinue = false;
                    break;
                default:
                    System.out.println("Enter valid mode of Payment.");
                    break;
            }
        }
    }

    static boolean containsAnyLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                return true;
            } else if (Character.isSpaceChar(c)) {
                return false;
            } else if (Character.isDigit(c)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static Boolean varifyExpiryDate(String expirydate) {
        String currentDate = getCurrentDate();
        int cardMonth = Integer.parseInt(expirydate.substring(0, 2));
        int cardYear = Integer.parseInt(expirydate.substring(3, 7));
        int currentMonth = Integer.parseInt(currentDate.substring(5, 6));
        int currentYear = Integer.parseInt(currentDate.substring(0, 4));
        if (cardYear - currentYear > 0) {
            return true;
        }
        if (cardYear - currentYear == 0) {
            if (cardMonth - currentMonth >= 0) {
                return true;
            }
        }
        return false;
    }

    static boolean paymentAppInterface(String totalBill) {
        System.out.println("\t\t  --------------------------------- ");
        System.out.println("\t\t| Requested amount: " + totalBill + "   | ");
        System.out.print("\t\t| confirm(y/n): ");
        String isConfirmed = scan.next();
        if (isConfirmed.equalsIgnoreCase("n")) {
            System.out.println("\t\t  --------------------------------- ");
            return false;
        }
        System.out.print("\t\t| Enter pin: ");
        String pin = scan.next();
        System.out.println("\t\t| Bill Paid Successfully             |");
        System.out.println("\t\t  --------------------------------- ");
        return true;
    }

    static boolean varifyUPI(String upi) {
        int atTheRate = 0, no = 0;
        if (Character.isDigit(upi.charAt(0))) {
            for (int i = 0; i < upi.length(); i++) {
                char c = upi.charAt(i);
                if (c == '@') {
                    atTheRate++;
                }
                if (Character.isDigit(c)) {
                    no++;
                }
                if (Character.isSpaceChar(c)) {
                    return false;
                }
            }
            if (no != 10) {
                return false;
            } else {
                return true;
            }
        }
        for (int i = 0; i < upi.length(); i++) {
            char c = upi.charAt(i);
            if (c == '@') {
                atTheRate++;
            }
            if (Character.isSpaceChar(c)) {
                return false;
            }
        }
        if (atTheRate != 1) {
            return false;
        }
        return true;
    }

    static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        String Year = Integer.toString(cal.get(Calendar.YEAR));
        String Month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        String Date = Integer.toString(cal.get(Calendar.DATE));
        return Year + "-" + Month + "-" + Date;
    }

}