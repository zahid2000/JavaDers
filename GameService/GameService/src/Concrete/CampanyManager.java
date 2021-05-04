package Concrete;

import Abstract.CampanyService;
import Entity.Concrete.Campany;

public class CampanyManager implements CampanyService {

	@Override
	public void add(Campany campany) {
		System.out.println(campany+" isimli kampanya eklendi");
		
	}

	@Override
	public void update(Campany campany) {
		System.out.println(campany+" isimli kampanya guncellendi");
		
		}

	@Override
	public void delete(Campany campany) {
		System.out.println(campany+" isimli kampanya silindi");
		
			}

}
