package Acts;
import java.util.Scanner;

public class LabAct1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("=== DFA String Acceptance Checker ===");
        System.out.println("This DFA accepts binary strings ending with '01'.");
        System.out.println("Type 'exit' or 'close' to stop the program.\n");

        while (true) {
            System.out.print("Enter a binary string: ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("close")) {
                System.out.println("\nProgram terminated by user.");
                break;
            }

            String currentState = "q0";
            boolean valid = true;

            // DFA simulation
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);

                if (symbol != '0' && symbol != '1') {
                    System.out.println("Invalid input! Only binary digits (0 and 1) are allowed.\n");
                    valid = false;
                    break;
                }

                switch (currentState) {
                    case "q0":
                        currentState = (symbol == '0') ? "q1" : "q0";
                        break;
                    case "q1":
                        currentState = (symbol == '1') ? "q2" : "q1";
                        break;
                    case "q2":
                        currentState = (symbol == '0') ? "q1" : "q0";
                        break;
                }
            }

            if (!valid) continue;

            // Output result
            if (currentState.equals("q2"))
                System.out.println("Output: Accepted ✅\n");
            else
                System.out.println("Output: Rejected ❌\n");
        }

        sc.close();
    }
}
