package adapters;

import java.rmi.RemoteException;
import java.time.ZoneId;

import abstracts.CustomerCheckService;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
	KPSPublicSoapProxy client=new KPSPublicSoapProxy();
	boolean result=false;
	try {
		result= client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalId()), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), customer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear());
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}

}
