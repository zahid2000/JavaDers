package staticDemo;

public  class ProductValidator {
	static {
		System.out.println("Contstructor calisti");
	}
	
	
	
	public static boolean isValidate(Product product) {
		if (product.price > 0 && !product.name.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void bisey() {
		
	}
	

}
