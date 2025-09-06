import java.util.Scanner;

class OnlineTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----Create Your Account-----");
        System.out.print("Enter your loginid: ");
        String id = sc.nextLine();
        System.out.print("Enter your password: ");
        String pwd = sc.nextLine();

        System.out.println("-----Account Created Successfully.-----");

        // LOGIN with 3 attempts
        System.out.println("-----Login-----");

        boolean loggedIn = false;
        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts && !loggedIn) {
            System.out.print("Enter ID: ");
            String loginid = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (id.equals(loginid) && pwd.equals(password)) {
                System.out.println("-----Login Successful.-----");
                loggedIn = true; // exit the loop
            } else {
                attempts++;
                if (attempts < maxAttempts) {
                    System.out.println("Invalid login access!! Try again. ("
                                       + (maxAttempts - attempts) + " attempts left)\n");
                } else {
                    System.out.println("Too many failed attempts! Exiting...");
                    return; // end program
                }
            }
        }

        // Reservation system starts only if logged in
        String pnr = "";
        String details = "";

        while (true) {
            System.out.println("\n1. Ticket Reservation ");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter your PNR number: ");
                pnr = sc.nextLine();
                System.out.print("Enter passenger name: ");
                String name = sc.nextLine();
                System.out.print("Enter Train number: ");
                String trainNo = sc.nextLine();
                System.out.print("Enter Train name: ");
                String trainName = sc.nextLine();
                System.out.print("Enter class type: ");
                String classtype = sc.nextLine();
                System.out.print("Enter date of journey: ");
                String doj = sc.nextLine();
                System.out.print("Enter from(place): ");
                String from = sc.nextLine();
                System.out.print("Enter to(destination): ");
                String to = sc.nextLine();

                details = "Name: " + name + ", TrainNo: " + trainNo + ", TrainName: " + trainName
                        + ", Class: " + classtype + ", Date: " + doj + ", From: " + from + ", To: " + to;

                System.out.println("\nReservation successful.");
                System.out.println("PNR: " + pnr);
                System.out.println(details + "\n");

            } else if (choice == 2) {
                if (pnr.equals("")) {
                    System.out.println("No reservation found!");
                } else {
                    System.out.print("Enter PNR number to cancel: ");
                    String cancel = sc.nextLine();
                    if (cancel.equals(pnr)) {
                        System.out.println("Reservation found: " + details);
                        System.out.print("Confirm cancellation (yes/no): ");
                        String conf = sc.nextLine();
                        if (conf.equalsIgnoreCase("yes")) {
                            pnr = "";
                            details = "";
                            System.out.println("Ticket cancelled successfully!");
                        } else {
                            System.out.println("Cancellation aborted.");
                        }
                    } else {
                        System.out.println("PNR not found!!");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting...\nThank You");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
