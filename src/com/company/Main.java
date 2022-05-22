package com.company;

import models.*;
import services.*;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        AuditService auditService = new AuditService();

        Boolean isLogged = false;

        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        Vector<Drink> drinks = new Vector<Drink>();
        HashSet<Dessert> desserts = new HashSet<Dessert>();

        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Address> addresses = new ArrayList<Address>();

        Pizza p1 = new Pizza("Diavola", 19.99, 500, false);
        Pizza p2 = new Pizza("Veggie", 16.39, 320, true);
        Pizza p3 = new Pizza("California", 22.59, 550, false);
        Pizza p4 = new Pizza("Chicken", 19.69, 445, false);
        Pizza p5 = new Pizza("Base Pizza", 12.99, 250, true);

        Drink d1 = new Drink("Cola", 5.49, 300, 330);
        Drink d2 = new Drink("Fanta", 4.49, 290, 330);
        Drink d3 = new Drink("Sprite", 4.99, 295, 330);
        Drink d4 = new Drink("Sparkling Water", 3.49, 50, 500);
        Drink d5 = new Drink("Still Water", 3.29, 40, 500);

        Dessert ds1 = new Dessert("Chocolate Ice Cream", 7.99, 300, true);
        Dessert ds2 = new Dessert("Vanilla Ice Cream", 7.99, 280, true);
        Dessert ds3 = new Dessert("Carrot Cake", 9.99, 220, false);
        Dessert ds4 = new Dessert("Chocolate Cookie", 3.99, 150, true);
        Dessert ds5 = new Dessert("Lava Cake", 11.39, 552, true);

        pizzas.add(p1);
        pizzas.add(p2);
        pizzas.add(p3);
        pizzas.add(p4);
        pizzas.add(p5);

        drinks.add(d1);
        drinks.add(d2);
        drinks.add(d3);
        drinks.add(d4);
        drinks.add(d5);

        desserts.add(ds1);
        desserts.add(ds2);
        desserts.add(ds3);
        desserts.add(ds4);
        desserts.add(ds5);

        while(true){
            System.out.println();
            System.out.println("Welcome to OOP Pizza Store");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Create account");
            System.out.println("3. Add delivery address");
            System.out.println("4. See the menu");
            System.out.println("5. Add items to the menu");
            System.out.println("6. Exit");
            String key = scanner.nextLine();
            switch(key){
                case "6":{
                    System.exit(0);
                }
                case "1":{
                    if(isLogged){
                        System.out.println("You are already logged in.");
                    }
                    else {
                        Boolean email_found = false;
                        Integer user_index=0;
                        System.out.println("E-mail: ");
                        String login_email = scanner.nextLine();

                        for(int i = 0; i < users.size(); i++)
                        {
                            if(users.get(i).getEmail() == login_email)
                            {
                                email_found = true;
                                user_index = i;
                            }
                            System.out.println(users.get(i).getEmail());
                        }
                        if(email_found == true)
                        {
                            System.out.println("Password: ");
                            String login_password = scanner.nextLine();
                            if(users.get(user_index).getPassword() == login_password)
                            {
                                isLogged = true;
                                System.out.println("Login was successful!");
                            }
                            else{
                                System.out.println("Bad password!");
                            }
                        }
                        else
                        {
                            System.out.println("Email not found!");
                        }
                    }
                    break;
                }
                case "2":{
                    User newUser = new User();

                    System.out.println("E-mail: ");
                    String inputEmail = scanner.nextLine();
                    newUser.setEmail(inputEmail);

                    System.out.println("Password: ");
                    String inputPassword = scanner.nextLine();
                    newUser.setPassword(inputPassword);

                    System.out.println("First name: ");
                    String inputFirstName = scanner.nextLine();
                    newUser.setFirst_name(inputFirstName);

                    System.out.println("Last name: ");
                    String inputLastName = scanner.nextLine();
                    newUser.setLast_name(inputLastName);

                    users.add(newUser);
                    auditService.addAction("Add user");
                    break;
                }
                case "3":{
                    if(isLogged == false){
                        System.out.println("You must login first.");
                        System.out.println();
                    }
                    else{
                        Address newAddress = new Address();

                        System.out.println("City: ");
                        String inputCity = scanner.nextLine();
                        newAddress.setCity(inputCity);

                        System.out.println("Street: ");
                        String inputStreet = scanner.nextLine();
                        newAddress.setStreet(inputStreet);

                        System.out.println("Postal code: ");
                        String inputPostalCode = scanner.nextLine();
                        newAddress.setPostalCode(inputPostalCode);

                        addresses.add(newAddress);
                        auditService.addAction("Add address");
                    }
                    break;
                }
                case "4":{
                    System.out.println("1. Pizza menu");
                    System.out.println("2. Dessert menu");
                    System.out.println("3. Drink menu");
                    String menu_key = scanner.nextLine();
                    switch(menu_key){
                        case "1":{
                            for(int i = 0; i < pizzas.size(); i++)
                            {
                                System.out.println(pizzas.get(i));
                            }
                            auditService.addAction("Print pizza menu");
                            break;
                        }
                        case "2":{
                            Iterator<Dessert> i = desserts.iterator();
                            while(i.hasNext())
                            {
                                System.out.println(i.next());
                            }
                            auditService.addAction("Print dessert menu");
                            break;
                        }
                        case "3":{
                            for(int i = 0; i < drinks.size(); i++)
                            {
                                System.out.println(drinks.get(i));
                            }
                            auditService.addAction("Print pizza menu");
                            break;
                        }
                    }
                    break;
                }
                case "5":{
                    if(isLogged) {
                        System.out.println("1. Add pizza");
                        System.out.println("2. Add dessert");
                        System.out.println("3. Add drink");
                        String add_key = scanner.nextLine();
                        switch (add_key) {
                            case "1": {
                                Pizza new_pizza = new Pizza();

                                System.out.println("Name: ");
                                String inputPizzaName = scanner.nextLine();
                                new_pizza.setName(inputPizzaName);

                                System.out.println("Price: ");
                                String inputPizzaPrice = scanner.nextLine();
                                Double pizzaprice = Double.parseDouble(inputPizzaPrice);
                                new_pizza.setPrice(pizzaprice);

                                System.out.println("Calories: ");
                                String inputPizzaCalories = scanner.nextLine();
                                Integer pizzacalories = Integer.parseInt(inputPizzaCalories);
                                new_pizza.setCalories(pizzacalories);

                                System.out.println("Is it vegetarian? (1-yes, 2-no): ");
                                String inputVegetarian = scanner.nextLine();
                                if (inputVegetarian == "1") {
                                    new_pizza.setIsVegetarian(true);
                                } else {
                                    new_pizza.setIsVegetarian(false);
                                }
                                auditService.addAction("Add pizza");
                                pizzas.add(new_pizza);

                                break;
                            }
                            case "2": {
                                Dessert new_dessert = new Dessert();

                                System.out.println("Name: ");
                                String inputDessertName = scanner.nextLine();
                                new_dessert.setName(inputDessertName);

                                System.out.println("Price: ");
                                String inputDessertPrice = scanner.nextLine();
                                Double dessertprice = Double.parseDouble(inputDessertPrice);
                                new_dessert.setPrice(dessertprice);

                                System.out.println("Calories: ");
                                String inputDessertCalories = scanner.nextLine();
                                Integer dessertcalories = Integer.parseInt(inputDessertCalories);
                                new_dessert.setCalories(dessertcalories);

                                System.out.println("Has sugar? (1-yes, 2-no): ");
                                String inputSugar = scanner.nextLine();
                                if (inputSugar == "1") {
                                    new_dessert.setHas_sugar(true);
                                } else {
                                    new_dessert.setHas_sugar(false);
                                }
                                auditService.addAction("Add dessert");
                                desserts.add(new_dessert);

                                break;
                            }
                            case "3": {
                                Drink new_drink = new Drink();

                                System.out.println("Name: ");
                                String inputDrinkName = scanner.nextLine();
                                new_drink.setName(inputDrinkName);

                                System.out.println("Price: ");
                                String inputDrinkPrice = scanner.nextLine();
                                Double drinkprice = Double.parseDouble(inputDrinkPrice);
                                new_drink.setPrice(drinkprice);

                                System.out.println("Calories: ");
                                String inputDrinkCalories = scanner.nextLine();
                                Integer drinkcalories = Integer.parseInt(inputDrinkCalories);
                                new_drink.setCalories(drinkcalories);

                                System.out.println("Quantity (in ml): ");
                                String inputDrinkQuantity = scanner.nextLine();
                                Integer drinkquantity = Integer.parseInt(inputDrinkQuantity);
                                new_drink.setSize(drinkquantity);
                                auditService.addAction("Add drink");
                                drinks.add(new_drink);

                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("You must log-in first!");
                    }
                    break;
                }
            }

        }
    }
}
