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
		System.out.println(game.getName() + " isimli oyun eklendi");

	}

	@Override
	public void delete(Game game) {
		System.out.println(game.getName() + " isimli oyun silindi");

	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName() + " isimli oyun guncellendi");

	}

}
