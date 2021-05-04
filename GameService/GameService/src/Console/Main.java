package Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import Adapters.MernisServiceAdapter;
import Concrete.GameManager;
import Concrete.GamerManager;
import Entity.Concrete.Campany;
import Entity.Concrete.Game;
import Entity.Concrete.Gamer;

public class Main {

	public static void main(String[] args) {
		GamerManager gamerManager=new GamerManager(new MernisServiceAdapter());
		Gamer gamer=new Gamer(1, "Berkan", "Çelik", new Date(2000,3,2), 10047176118L);
		
		GameManager gameManager=new GameManager();
		Game game=new Game(1, "CSGO", 23.3);
		
		
		Campany campany=new Campany(1, "Ramazan", new Date(2021,1,15), new Date(2021,8,30));

		gamerManager.add(gamer);
		gameManager.buyWithCompany(game, gamer, campany);
	}

}
