package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.util.Locale;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CheckCandidateService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CheckCandidateService{

	@Override
	public boolean checkCandidate(Candidate candidate) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity())  , candidate.getFirstName().toUpperCase(new Locale("tr")), candidate.getLastName().toUpperCase(new Locale("tr")), candidate.getBirthDate().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
