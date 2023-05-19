import java.util.Scanner;
import java.util.ArrayList;

public class customercare {
    static String calling_plan;
    static String data_plan;
    static ArrayList<String> complaints = new ArrayList<>();
    static boolean sim_activated = false;
    static Scanner scanner = new Scanner(System.in);

    public static int getChoice(String prompt, String[] display_options) {
        System.out.println(prompt);
        while (true) {
            int list_item = 1;
            for (String option : display_options) {
                System.out.printf("%d. %s\n", list_item++, option);
            }

            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input a valid integer.");
                continue;
            }

            if (option > 0 && option <= display_options.length) {
                return option;
            } else {
                System.out.println("Invalid option selected. Please pick again.");
            }
        }
    }

    public static boolean simNotActivatedCheck() {
        if (!sim_activated) {
            System.out.println("Please activate your SIM card first.");
        }
        return !sim_activated;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our customer care!");
        String main_prompt = "Please choose an option:";
        String[] main_options = {
            "Check Balance",
            "Recharge Balance",
            "Buy Data plan",
            "Sim Activation",
            "Register Complaint",
            "View Complains",
            "Talk to a specialist",
            "Exit",
        };
        boolean stop_loop = false;

        while (true) {
            if (stop_loop) {break;}
            int choice = getChoice(main_prompt, main_options);
            switch (choice) {
                case 1:
                    if (simNotActivatedCheck()) {break;}
                    System.out.printf("Calling plan: %s\nData plan: %s\n", calling_plan, data_plan);
                    break;
                case 2:
                    if (simNotActivatedCheck()) {break;}
                    String[] calling_plans = {
                        "₹299 30 days unlimited calls",
                        "₹499 75 days unlimited calls"
                    };
                    int plan = getChoice("Select a plan:", calling_plans);
                    calling_plan = calling_plans[plan - 1];
                    System.out.println("Plan activated.");
                    break;
                case 3:
                    if (simNotActivatedCheck()) {break;}
                    String[] data_plans = {
                        "50$ 30 days 1GB/day",
                        "100$ 30 days 1GB/day"
                    };
                    int selected_data_plan = getChoice("Select a plan:", data_plans);
                    data_plan = data_plans[selected_data_plan - 1];
                    System.out.println("Plan activated.");
                    break;
                case 4:
                    if (sim_activated) {
                        System.out.println("Your SIM card is already active.");
                    } else {
                        sim_activated = true;
                        System.out.println("Your SIM card has been activated.");
                    }
                    break;
                case 5:
                    System.out.println("We're sorry to hear you're facing issues. Please type your complaint: ");
                    String complaint = scanner.nextLine();
                    complaints.add(complaint);
                    System.out.printf("We've recieved your complaint. Complaint no: #%d\n", complaints.size());
                    break;
                case 6:
                    if (complaints.size() == 0) {
                        System.out.println("You haven't raised any complaints.");
                        break;
                    }
                    System.out.println("Here are all the complaints you've made:");
                    for (int i = 0; i < complaints.size(); i++) {
                        System.out.printf("%d.\n " + complaints.get(i), i + 1);
                    }
                    break;
                case 7:
                    System.out.println("A specialist has been contacted. We will get back to you in a few minutes!");
                    break;
                case 8:
                    System.out.println("Thank you for using our services.");
                    stop_loop = true;
                    break;
            }
        }
    }
}