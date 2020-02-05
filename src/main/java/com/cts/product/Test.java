package com.cts.product;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.model.Product;
import com.cts.product.service.ProductService;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("--- Stated..");

		//ProductDao dao = ac.getBean(ProductDao.class);

		ProductService ps=ac.getBean(ProductService.class);
		Product prod2 = new Product(300, "Test", 120.0);
		ps.saveProduct(prod2);

		Product prod = new Product(100, "Spring-JDBC-Test", 65.0);
		ps.saveProduct(prod);
		Product prod1 = new Product(200, "Spring-JDBC-Test", 100.0);
		ps.saveProduct(prod1);
		int ch;

		do {
			System.out.println(
					"What would you like to do with the list?\n 1. find all products\n2. find a product by id\n"
							+ "3. find products by name \n4. find products with in a price range\n5. find products with in id range\n6. delete a product using Id\n7. update a product by id\n8. exit");
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				List<Product> prods = ps.findAll();
				printList(prods);
				break;

			// System.out.println("Total: " + prods.size());

			/*
			 * dao.findByName("Test").forEach(product->{
			 * System.out.println(product.getProductId());
			 * System.out.println(product.getProductName());
			 * System.out.println(product.getPrice());
			 * System.out.println("-----------------------------"); });
			 * 
			 */
			case 2:
				Product product = ps.findById(100);

				if (product != null) {
					System.out.println("Product with id 100 is\n" + product.toString());
					System.out.println("-----------------------------");
				} else {
					System.out.println("Product id not found");
				}
				break;

			case 3:
				List<Product> prodList = ps.findByName("Spring-JDBC-Test");
				printList(prodList);
				break;

			case 4:
				List<Product> prodList1 = ps.findByPriceRange(100, 130);
				System.out.println("Product within price range 100 and 130 are ");
				printList(prodList1);
				break;
//		
			case 5:
				List<Product> prodList2 = ps.findByIdRange(100, 300);
				System.out.println(prodList2.size());
				System.out.println("Product within id range 100 and 300 are ");
				printList(prodList2);
				break;
//		
			case 6:
				int res = ps.deleteById(100);
				System.out.println(res + " row deleted");
				break;
//		
			case 7:
				int res1 = ps.updateNameById(300, "Spring-Boot");
				System.out.println(res1 + "row updated");
				break;
			default:
				System.out.println("Program stopped");
				System.exit(0);
			}
		} while (ch != 8);
		ac.close();

	}

	public static void printList(List<Product> list) {
		int c = 1;
		for (Product p : list) {
			System.out.println(c + ". " + p.toString());
			System.out.println("-----------------------------");
			c++;
		}
		c = 1;
	}

}
