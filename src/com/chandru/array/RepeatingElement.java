
/*
package com.chandru.array;

import java.util.Scanner;

public class RepeatingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int size = scanner.nextInt();

        if (size > 0) {
            int[] num = new int[size];
            System.out.println("Now enter the " + size + " elements one by one:");
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                num[i] = scanner.nextInt();
            }

            System.out.println("\nYou entered these numbers:");
            for (int n : num) {
                System.out.print(n + " ");
            }
            System.out.println();

            System.out.print("\nEnter the element to count: ");
            int userInput = scanner.nextInt();
            
            int count = 0;
            for (int eachElement : num) {
                if (userInput == eachElement) {
                    count++;
                }
            }

            // Move the result logic OUTSIDE the loop
            if (count > 0) {
                System.out.println(userInput + " is repeated " + count + " time(s).");
            } else {
                System.out.println("The number " + userInput + " is not present in the array.");
            }
        }
        scanner.close();
    }
}

*/

package com.chandru.array;

import java.util.Scanner;

public class RepeatingElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = 0;

		// --- STEP 1: GET VALID ARRAY SIZE ---
		while (true) {
			System.out.print("Enter the length of the array (or type 'exit' to quit): ");
			String input = scanner.nextLine().trim();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("Program closed.");
				return;
			}

			try {
				size = Integer.parseInt(input);
				if (size > 0) {
					break; // Success!
				} else {
					System.out.println("Error: Please enter a number greater than 0.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input: '" + input + "' is not a valid whole number.");
			}
		}

		// --- STEP 2: FILL THE ARRAY ---
		int[] num = new int[size];
		System.out.println("Filling array of size " + size + ". Type 'exit' anytime to quit.");

		for (int i = 0; i < size; i++) {
			while (true) {
				System.out.print("Enter element " + (i + 1) + ": ");
				String input = scanner.nextLine().trim();

				if (input.equalsIgnoreCase("exit")) {
					System.out.println("Program closed.");
					return;
				}

				try {
					num[i] = Integer.parseInt(input);
					break; // Move to next element
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid integer.");
				}
			}
		}

		// --- STEP 3: SEARCH LOOP ---
		while (true) {
			System.out.println("\n--- Search Mode ---");
			System.out.println("Enter a number to count, or type 'exit' to stop:");
			String input = scanner.nextLine().trim();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("Exiting program. Goodbye!");
				break;
			}

			try {
				int target = Integer.parseInt(input);
				int count = 0;

				for (int eachElement : num) {
					if (target == eachElement) {
						count++;
					}
				}

				if (count > 0) {
					System.out.println(">> Result: " + target + " appears " + count + " time(s).");
				} else {
					System.out.println(">> Not Found: " + target + " is not in the array.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid input! '" + input + "' is not a number. Use 'exit' to quit.");
			}
		}
		scanner.close();
	}
}
