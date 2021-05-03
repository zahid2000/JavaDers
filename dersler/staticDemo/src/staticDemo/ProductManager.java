package staticDemo;

public class ProductManager {
	public void add(Product product) {

		if (ProductValidator.isValidate(product)) {
			System.out.println("Eklendi");
		} else {
			System.out.println("Urun bilgileri gecersizdir");
		}
		
	}
	


}
