package Main;

import com.dbmanager.DbHandler;
import com.inventoryManager.Display;
import com.inventoryManager.Item;
import com.inventoryManager.ItemHandler;
import com.inventoryManager.UserInputs;
import com.login.Login;
import com.login.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        DbHandler dbHandler = new DbHandler();
        dbHandler.GetStatementExecute();

        /**
         * Uses the json files to manage inventory
         */

        /*

        //User Login
        User user = new User();
        System.out.println("User Login");
        Login newLogin = null;
        boolean val=false;

        try {
            newLogin = new Login(user.getUser());
            val=newLogin.userLogin();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (val) {
            try {

                if (true){

                    Scanner scanner = new Scanner(System.in);
                    ItemHandler itemHandler = new ItemHandler();
                    Display display = new Display();
                    UserInputs userInputs = new UserInputs(scanner, display, itemHandler);

                    display.print("Select One Option : ");
                    display.print("Enter 1 for Add Book");
                    display.print("Enter 2 for Delete Book");
                    display.print("Enter 3 for Search Book");
                    display.print("Enter 4 for View All Books");
                    display.print("Enter 5 for Update Quantity of a Book");
                    display.print("Enter 6 for Purchasing a Book");
                    display.print("Enter 0 to Exit");

                    int option= scanner.nextInt();
                    scanner.nextLine();

                    if (option==1){
                        itemHandler.addItem(userInputs.addItemInputs());
                    } else if (option ==2) {
                        itemHandler.deleteItem(userInputs.deleteItemInput());
                    } else if (option == 3) {
                        itemHandler.searchItem( userInputs.searchInput());
                    } else if (option==4){
                        List<Item> itemList=itemHandler.readAllItems();
                        for (Item item:itemList) {
                            System.out.println(item);
                        }
                    } else if (option == 5) {
                        Map<String,Integer> updateBook=userInputs.updateQtyInput();
                        itemHandler.updateQty(updateBook.keySet().toArray()[0].toString(),Integer.parseInt(updateBook.values().toArray()[0].toString()));

                    } else if (option == 6) {
                        Map<String,Integer> purchaseBook=userInputs.purchaseInput();
                        itemHandler.purchaseItem(purchaseBook.keySet().toArray()[0].toString(),Integer.parseInt(purchaseBook.values().toArray()[0].toString()));

                    } else if (option == 0) {
                        break;
                    }

                    //Add user
                    //userInputs.userLoginInput().setUser();

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e){
                System.out.println("Invalid Input, try again...");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

*/

        /**
         * use the sql database to manage inventory
         */

        try {
            Scanner scanner = new Scanner(System.in);
            ItemHandler itemHandler = new ItemHandler();
            Display display = new Display();
            UserInputs userInputs = new UserInputs(scanner, display, itemHandler);

            //Add to DB
            dbHandler.AddStatementExecute(userInputs.addItemInputs());
            //Update DB
            dbHandler.updateStatementExecute(userInputs.updateQtyInput());
            //Delete from DB
            dbHandler.deleteStatementExceute(userInputs.deleteItemInput());
            //Search DB
            dbHandler.searchStatementExecute(userInputs.searchInput());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}