package Abstract;

import Entity.Concrete.Campany;
import Entity.Concrete.Game;
import Entity.Concrete.Gamer;
import Entity.Concrete.Sale;

public interface SalesService {
	void sale(Sale sale, Game game, Gamer gamer);

	void saleWithCampany(Sale sale, Game game, Gamer gamer, Campany campany);

	void update(Sale sale);

	void delete(Sale sale);
}
