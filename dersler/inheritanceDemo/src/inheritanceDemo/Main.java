package inheritanceDemo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OgretmenKrediManager krediManager = new OgretmenKrediManager();
		krediManager.hesapla();
		
		KrediUI  krediUI=new KrediUI();
		krediUI.krediHesapla(new AskerKrediManager());
	}

}
