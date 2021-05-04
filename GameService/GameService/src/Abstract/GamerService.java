package Abstract;

import Entity.Concrete.Gamer;

public interface GamerService {
	void add(Gamer gamer);
	void update(Gamer gamer);
	void delete(Gamer gamer);
}
