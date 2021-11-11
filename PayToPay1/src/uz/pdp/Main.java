package uz.pdp;

import uz.pdp.catagory.model.Catagory;
import uz.pdp.catagory.model.Service;
import uz.pdp.catagory.model.ServiceField;
import uz.pdp.catagory.service.BaseCatagoryService;
import uz.pdp.catagory.service.CatagoryService;
import uz.pdp.catagory.service.ServiceFieldService;
import uz.pdp.catagory.service.ServiceService;
import uz.pdp.model.Card;
import uz.pdp.model.User;
import uz.pdp.service.CardService;
import uz.pdp.service.HistoryService;
import uz.pdp.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {


   static Scanner scannerInt = new Scanner(System.in);
   static Scanner scannerStr = new Scanner(System.in);
   static Scanner scannerDouble = new Scanner(System.in);
   static UserService userService = new UserService();
   static CardService cardService = new CardService();
   static HistoryService historyService = new HistoryService();
   static CatagoryService catagoryService = new CatagoryService();
   static ServiceService serviceService = new ServiceService();
   static ServiceFieldService serviceFieldService = new ServiceFieldService();

    static int stepCode1 = 1;

    public static void main(String[] args) {

        while (stepCode1 != 0) {
            System.out.println("1. Sign up as admin\t 2. Sing up as user\t 0. Exit");
            stepCode1 = scannerInt.nextInt();
            if (stepCode1 == 1) {
                System.out.println("Enter name");
                String name = scannerStr.nextLine();
                System.out.println("Enter phone number");
                String phoneNumber = scannerStr.nextLine();
                if (userService.checkAdmin(phoneNumber)){
                    int stepCode = 1;
                    while (stepCode!=0){
                        System.out.println("1. Add catagory \t 2. Add service \t 0. EXIT");
                        stepCode = scannerInt.nextInt();
                        switch (stepCode){
                            case 1:
                                Catagory catagory = new Catagory();
                                System.out.println("Enter catagory name");
                                catagory.setName(scannerStr.nextLine());
                                if (catagoryService.add(catagory)==-1)
                                    System.out.println("Available catagory");
                                else
                                    System.out.println("Catagory is added successfully");
                                break;
                            case 2:
                                Service service = new Service();
                                System.out.println("Enter catagory name");
                                String name1 = scannerStr.nextLine();
                                if (catagoryService.check(name1) !=null){
                                    System.out.println("Enter service name");
                                    service.setName(scannerStr.nextLine());
                                    service.setCatagoryId(catagoryService.check(name1).getId());
                                    if (serviceService.add(service)==-1)
                                        System.out.println("Available service");
                                    else{
                                        System.out.println("Service is added successfully");
                                        ServiceField serviceField = new ServiceField();
                                        System.out.println("Enter how many fields ");
                                        serviceField.setId();
                                        UUID id =  serviceField.getId();
                                        serviceField.setServiceId(service.getId());
                                        UUID id1 = serviceField.getServiceId();
                                        int count = scannerInt.nextInt();
                                        for (int i=0; i<count; i++){
                                            String nameField = scannerStr.nextLine();
                                            serviceField.setName(nameField);
                                            String titleField = scannerStr.nextLine();
                                            serviceField.setTitle(titleField);
                                        }

                                        if (serviceFieldService.add(serviceField)==-1)
                                            System.out.println("Available service field");
                                        else
                                            System.out.println("Service field is added successfully");
                                    }
                                }
                                else
                                    System.out.println("Unavailable cagagory");

                                break;
                        }
                    }
                }
                else
                    System.out.println("Unavailable admin");
            } else if (stepCode1 == 2) {
                int stepCode = 1;
                while (stepCode != 0) {
                    System.out.println("1. Sign up \t 2. Sing in \t 0. Exit");
                    stepCode = scannerInt.nextInt();
                    if (stepCode == 1) {
                        System.out.println("Enter name");
                        String name = scannerStr.nextLine();
                        System.out.println("Enter phone number");
                        String phoneNumber = scannerStr.nextLine();
                        if (userService.checkUser(phoneNumber)) {
                            int stepCode2 = 1;
                            while (stepCode2 != 0) {
                                System.out.println("1. Add card \t 2. Delete card\t 3. Fill balance \t 4. Transfer money\t 5. Get history \t 6. Get card list\t 7. Payment 0. Exit ");
                                stepCode2 = scannerInt.nextInt();
                                switch (stepCode2) {
                                    case 1:
                                        Card card = new Card();
                                        System.out.println("Enter name");
                                        card.setName(scannerStr.nextLine());
                                        System.out.println("Enter card number");
                                        card.setCardNumber(scannerStr.nextLine());
                                        if (cardService.checkCard(card.getCardNumber()) != null)
                                            System.out.println("Available card");
                                        else {
                                            card.setPhoneNumber(phoneNumber);
                                            card.setId();
                                            System.out.println("Card added successfully");
                                            cardService.add(card);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Enter card number");
                                        String card1 = scannerStr.nextLine();
                                        cardService.delete(card1);
                                        break;
                                    case 3:
                                        System.out.println("Enter card number");
                                        String c = scannerStr.nextLine();
                                        if (cardService.checkCard(c) != null) {
                                            System.out.println("Enter money");
                                            if (cardService.fillBalance(c, scannerDouble.nextDouble()) == 10)
                                                System.out.println("Balance is filled successfully");
                                            else
                                                System.out.println("Unavailable error");
                                        } else
                                            System.out.println("Card is not found");
                                        break;
                                    case 4:
                                        System.out.println("Enter card that you want to transfer from");
                                        String c1 = scannerStr.nextLine();
                                        System.out.println("Enter card that you want to transfer to");
                                        String c2 = scannerStr.nextLine();
                                        System.out.println("Enter amount");
                                        double amount = scannerDouble.nextDouble();
                                        cardService.payToPay(c1, c2, amount, historyService);
                                        break;
                                    case 5:
                                        System.out.println("Enter card number");
                                        historyService.getHistoryList(scannerStr.nextLine());
                                        break;

                                    case 6:
                                        cardService.get();
                                        break;

                                    case 7:
                                        getPayment();
                                        break;
                                }
                            }
                        } else
                            System.out.println("Unavailable user");
                    } else {
                        User user = new User();
                        System.out.println("Enter name");
                        user.setName(scannerStr.nextLine());
                        System.out.println("Enter phone number");
                        user.setPhoneNumber(scannerStr.nextLine());
                        System.out.println("Enter username");
                        user.setUsername(scannerStr.nextLine());
                        System.out.println("Enter password");
                        user.setPassword(scannerStr.nextLine());
                        user.setId();
                        if (userService.add(user) == -1)
                            System.out.println("Available user");
                        else
                            System.out.println("User is added successfully");
                    }

                }


            }
        }


    }

    private static void getPayment() {
        ArrayList<Catagory> catagories = catagoryService.getAll();
        ArrayList<Service> services = serviceService.getAll();
        int ind=1;
        for (Catagory catagory : catagories) {
            System.out.println((ind++)+"."+catagory.getName());
        }
        System.out.println("===================");
        stepCode1 = scannerInt.nextInt();
        Catagory catagory = catagories.get(stepCode1 - 1);
        ind=1;
        for (Service service : services) {
            if(service.getCatagoryId().equals(catagory.getId()))
                System.out.println((ind++)+"."+service.getName());
        }
    }
}