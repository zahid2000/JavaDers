package Abstract;

import Entity.Concrete.Campany;
import Entity.Concrete.Game;
import Entity.Concrete.Gamer;

public interface GameService {
	void add(Game game);

	void update(Game game);

	void delete(Game game);

}
