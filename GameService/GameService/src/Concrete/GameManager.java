package Concrete;

import java.util.Calendar;
import java.util.Date;

import Abstract.GameService;
import Entity.Concrete.Campany;
import Entity.Concrete.Game;
import Entity.Concrete.Gamer;

public class GameManager implements GameService {

	@Override
	public void add(Game game) {
		System.out.println(game.getName()+" isimli oyun eklendi");
		
	}

	@Override
	public void delete(Game game) {
		System.out.println(game.getName()+" isimli oyun silindi");
		
	}

	@Override
	public void buy(Game game, Gamer gamer) {
		System.out.println(game.getName()+" isimli oyun"+gamer.getFirstName()+" "+gamer.getLastName()+" tarafından alındı");
		
	}

	@Override
	public void buyWithCompany(Game game, Gamer gamer, Campany campany) {
		System.out.println(game.getName()+" isimli oyun "+campany.getName()+" kampanya ile "+gamer.getFirstName()+" "+gamer.getLastName()+" tarafından alındı");
		
	}

}
