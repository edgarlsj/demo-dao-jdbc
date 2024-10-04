import model.DaoFactory.DaoFactory;
import model.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.*;

public class Application {
    public static void main(String[] args) {

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







    }
}
