import java.nio.file.Path;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BBSRandom rand = new BBSRandom();
        Graph graph = new Graph();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Print Graph");
            System.out.println("2. Find Path");
            System.out.println("3. Make New Graph");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                graph.printGraph();
            }else if(choice == 2){
                System.out.println("Enter start node: ");
                int start = sc.nextInt();
                System.out.println("Enter end node: ");
                int end = sc.nextInt();
                PathFinder.findPath(graph, start, end);
            } else if (choice == 3) {
                graph = new Graph();
                System.out.println("New graph created!");
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break; // exit the loop
            } else {
                System.out.println("Invalid choice.");
            }

        }
    }
}

