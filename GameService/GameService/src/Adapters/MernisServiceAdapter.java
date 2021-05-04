package Adapters;

import Abstract.GamerCheckService;
import Entity.Abstract.Entity;
import Entity.Concrete.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements GamerCheckService{


@SuppressWarnings("deprecation")
@Override
public boolean checkIfGamer(Gamer gamer) {
	KPSPublicSoapProxy client=new KPSPublicSoapProxy();
	boolean result=false;
	try {
		result=client.TCKimlikNoDogrula(gamer.getNationalIdentity(), gamer.getFirstName().toUpperCase(), gamer.getLastName().toUpperCase(), gamer.getDateOfBirth().getYear());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

}
