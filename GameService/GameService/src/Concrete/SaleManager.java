package Concrete;

import Abstract.SalesService;
import Entity.Concrete.Campany;
import Entity.Concrete.Game;
import Entity.Concrete.Gamer;
import Entity.Concrete.Sale;

public class SaleManager implements SalesService {

	@Override
	public void sale(Sale sale, Game game, Gamer gamer) {
		System.out.println(game.getName()+" isimli oyun "+gamer.getFirstName()+" isimli kullaniciya satildi");
	}

	@Override
	public void saleWithCampany(Sale sale, Game game, Gamer gamer, Campany campany) {
		System.out.println(game.getName()+" isimli oyun "+campany.getName()+" kampanya ile "+gamer.getFirstName()+" isimli kullaniciya satildi");
	
	}

	@Override
	public void update(Sale sale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sale sale) {
		// TODO Auto-generated method stub
		
	}



}
