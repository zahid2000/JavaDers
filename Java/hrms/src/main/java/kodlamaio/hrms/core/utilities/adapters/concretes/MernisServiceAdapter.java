package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CheckRealPersonService;
import kodlamaio.hrms.core.utilities.adapters.models.MernisPerson;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CheckRealPersonService{

	@Override
	public boolean validate(MernisPerson mernisPerson) {
//		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
//		boolean result=false;
//		try {
//			result=client.TCKimlikNoDogrula(Long.parseLong(mernisPerson.getIdentityNumber())  , mernisPerson.getFirstName().toUpperCase(new Locale("tr")), mernisPerson.getLastName().toUpperCase(new Locale("tr")), mernisPerson.getBirthDate().getYear());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
		return true;
	}

}
