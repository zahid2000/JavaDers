package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcDao;
import nLayeredDemo.entities.concretes.Product;


public class Main {

	public static void main(String[] args) {
	ProductService productService=new ProductManager(new AbcDao(),new JLoggerManagerAdapter());
	
	Product product=new Product(1,2,"mouse",12,2);
	productService.add(product);
	}

}
