package view;

import controller.Controller;
import exception.ParsePersonException;
import exception.SavePersonException;
import model.repository.PersonRepository;
import model.repository.impl.PersonRepositoryImpl;

import java.util.Scanner;

public class View {
    public static void runApp(){
        PersonRepository personRepository = new PersonRepositoryImpl();
        Controller controller = new Controller(personRepository);
        View view = new View(controller);
        view.run();
    }

    Controller controller;
    Scanner scanner;

    public View(Controller controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void run(){
        while(true) {
            try {
                tryPrompt();
            } catch (ParsePersonException | SavePersonException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void tryPrompt() throws ParsePersonException, SavePersonException {
        System.out.print("input you data. For example Ivan ivanov ivanovich 12.02.1997 89113874810 m(f): ");
        String stringData = scanner.nextLine();
        controller.savePersonFromString(stringData);
        System.out.println("save person is successfully!");
    }
}
