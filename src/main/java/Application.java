import model.DaoFactory.DaoFactory;
import model.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Department obj = new Department(2,"books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date() ,3000.00,obj);
        System.out.println(obj);
        System.out.println(seller);

        SellerDAO sellerDAO = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller1 = sellerDAO.findById(1);
        System.out.println(seller1);

        System.out.println("=== TEST 2: Seller findByDepartment ===");

        Department department = new Department(2, null);
        List<Seller> seller2 = sellerDAO.findByDepartment(department);
        seller2.stream().forEach(System.out::println);

        System.out.println("=== TEST 3: Seller findAll ===");

        seller2 = sellerDAO.findAll();
        seller2.stream().forEach(System.out::println);


        System.out.println("=== TEST 4: Seller insert ===");

        Seller sellerInsert = new Seller(null,"Teste","teste@gmail.com", new Date(),3000.00, department );
        sellerDAO.insert(sellerInsert);
        System.out.println("Insert! new id ="+ sellerInsert.getId());


        System.out.println("=== TEST 5: Seller update ===");

        seller = sellerDAO.findById(1);
        seller.setName("Martha Whane");


        sellerDAO.update(seller);
        System.out.println("Update complete!");


        System.out.println("=== TEST 6: Seller Delete ===");

        System.out.println("Enter id for delete test ");
        int id = sc.nextInt();
        sellerDAO.deleteById(id);
        System.out.println("Delete complete");

        sc.close();









    }
}
