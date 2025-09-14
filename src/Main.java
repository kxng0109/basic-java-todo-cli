import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> tasks = new ArrayList<>();
		boolean isRunning = true;

		while (isRunning){
			printMenu();

			try{
				byte userSelection = scanner.nextByte();
				scanner.nextLine();
				System.out.println();

				switch (userSelection){
					case 1 -> addTask(scanner, tasks);
					case 2 -> listTasks(tasks);
					case 3 -> markComplete(scanner, tasks);
					case 4 -> removeTask(scanner, tasks);
					case 5 -> {
						System.out.println("Bye!");
						isRunning = false;
					}
					default -> System.out.println("Invalid input. Selection must be between 1 and 5!");
				}
			}catch (InputMismatchException e){
				scanner.nextLine();
				System.out.println("Invalid input!");
			}
		}
		scanner.close();
	}

	static void printMenu(){
		System.out.println("\nWelcome to a basic To-Do CLI. What do you want to do?");
		System.out.println("1. Add task");
		System.out.println("2. List tasks");
		System.out.println("3. Complete task");
		System.out.println("4. Remove task");
		System.out.println("5. Exit/Quit");
		System.out.print("Select an option (1-5): ");
	}

	static void addTask(Scanner scanner, ArrayList<String> tasks){
		System.out.print("Enter the task you want to add to your To-Do list?: ");
		String task = scanner.nextLine().trim();

		if (task.isEmpty()){
			System.out.println("No input received. Nothing added.");
			return;
		}

		tasks.add(task);
		System.out.println("Task added!");
	}

	static void listTasks(ArrayList<String> tasks){
		if (tasks.isEmpty()) {
			System.out.println("You have no tasks!");
			return;
		}

		System.out.println("\nList of tasks saved:");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, tasks.get(i));
		}
	}

	static void markComplete(Scanner scanner, ArrayList<String> tasks){
		if(tasks.isEmpty()){
			System.out.println("No tasks to complete.");
			return;
		}

		System.out.printf("Enter the index of the task (1-%d) you want to mark as complete: ", tasks.size());
		int i = scanner.nextInt();
		scanner.nextLine();

		int realIndex = i - 1;

		if(realIndex > tasks.size() || realIndex < 0){
			System.out.printf("Invalid input! Enter the correct index (1-%d).\n", tasks.size());
			return;
		}

		tasks.remove(realIndex);
		System.out.println("Task marked as complete.");
	}

	static void removeTask(Scanner scanner, ArrayList<String> tasks){
		if(tasks.isEmpty()){
			System.out.println("No tasks to remove.");
			return;
		}

		System.out.printf("Enter the index of the task (1-%d) you want to remove: ", tasks.size());
		int i = scanner.nextInt();
		scanner.nextLine();

		int realIndex = i - 1;

		if(realIndex > tasks.size() || realIndex < 0){
			System.out.printf("Invalid input! Enter the correct index (1-%d).\n", tasks.size());
			return;
		}

		tasks.remove(realIndex);
		System.out.println("Task removed.");
	}
}
