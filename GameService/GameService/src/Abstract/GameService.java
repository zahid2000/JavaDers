package Abstract;

import Entity.Concrete.Campany;
import Entity.Concrete.Game;
import Entity.Concrete.Gamer;

public interface GameService {
	void add(Game game);

	void delete(Game game);

	void buy(Game game, Gamer gamer);
	void buyWithCompany(Game game,Gamer gamer,Campany campany);
}
