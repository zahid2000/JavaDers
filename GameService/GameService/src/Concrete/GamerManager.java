package Concrete;

import Abstract.GamerCheckService;
import Abstract.GamerService;
import Entity.Concrete.Gamer;

public class GamerManager implements GamerService {
	private GamerCheckService gamerCheckService;
	

	public GamerManager(GamerCheckService gamerCheckService) {
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(Gamer gamer) {
		if(gamerCheckService.checkIfGamer(gamer)) {
		System.out.println(gamer.getFirstName() + " " + gamer.getLastName() + " isimli oyuncu eklendi");
		}else {
			System.out.println("Not a valid person");
		}
	}

	@Override
	public void update(Gamer gamer) {
		if(gamerCheckService.checkIfGamer(gamer)) {
			System.out.println(gamer.getFirstName() + " " + gamer.getLastName() + " isimli oyuncu guncellendi");
			}else {
				System.out.println("Not a valid person");
			}
	}

	@Override
	public void delete(Gamer gamer) {
		if(gamerCheckService.checkIfGamer(gamer)) {
			System.out.println(gamer.getFirstName() + " " + gamer.getLastName() + " isimli oyuncu silindi");
			}else {
				System.out.println("Not a valid person");
			}
	}

}
