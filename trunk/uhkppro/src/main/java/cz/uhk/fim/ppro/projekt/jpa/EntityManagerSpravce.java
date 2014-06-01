package cz.uhk.fim.ppro.projekt.jpa;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cz.uhk.fim.ppro.projekt.Katastr;
import cz.uhk.fim.ppro.projekt.Klient;
import cz.uhk.fim.ppro.projekt.ListVlastnictvi;
import cz.uhk.fim.ppro.projekt.Parcela;
import cz.uhk.fim.ppro.projekt.ParcelaSmlouva;
import cz.uhk.fim.ppro.projekt.Smlouva;
import cz.uhk.fim.ppro.projekt.Spravce;

@Repository
@Transactional
public class EntityManagerSpravce implements Spravce {

	@PersistenceContext( type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Collection<Klient> getKlienti() throws DataAccessException {
		return this.em
				.createQuery(
						"SELECT klient FROM Klient klient ORDER BY klient.lastName, klient.firstName")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Collection<Parcela> getParcely() throws DataAccessException {
		return this.em
				.createQuery(
						"SELECT parcela FROM Parcela parcela ORDER BY parcela.lv.katastr.kod, parcela.lv.cislo, parcela.kmenoveCislo, parcela.podlomeniCisla asc")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Collection<ListVlastnictvi> getListyVlastnictvi()
			throws DataAccessException {
		return this.em.createQuery(
				"SELECT lv FROM ListVlastnictvi lv ORDER BY lv.cislo")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Collection<Katastr> getKatastry() throws DataAccessException {
		return this.em.createQuery(
				"SELECT katastr FROM Katastr katastr ORDER BY katastr.kod")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Collection<Smlouva> getSmlouvy() throws DataAccessException {
		return this.em
				.createQuery(
						"SELECT smlouva FROM Smlouva smlouva ORDER BY smlouva.identifikator")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<ParcelaSmlouva> getParcelaSmlouvy()
			throws DataAccessException {
		return this.em
				.createQuery(
						"SELECT parcelaSmlouva from ParcelaSmlouva parcelaSmlouva ORDER BY parcelaSmlouva.smlouva_id")
				.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Collection<Klient> findKlienti(String lastName)
			throws DataAccessException {
		Query q = this.em
				.createQuery("SELECT klient FROM Klient klient WHERE lower(klient.firstName +' '+ klient.lastName) like :lastName");

		q.setParameter("lastName", "%" + lastName.toLowerCase() + "%");

		return q.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Collection<Smlouva> findSmlouva(String lastName,
			String identifikator, Date datumOd) throws DataAccessException {
		Query q = this.em
				.createNativeQuery("select smlouva,parcela from SMLOUVA smlouva, KLIENT kl,PARCELA par, PAR_VE_SML parmsl where smlouva.klient.id = kl.id and smlouva.id=parsml.smlouva.id and"
						+ " parsml.parcela.id=parcela.id and (:lastName is null or kl.lastName like :lastName)"
						+ " and (:identifikator is null or smlouva.identifikator like :identifikator) and (:datumOd is null or smlouva.datumod=:datumOd) ");

		q.setParameter(1, lastName);
		q.setParameter(2, lastName);
		q.setParameter(3, identifikator);
		q.setParameter(4, identifikator);
		q.setParameter(5, datumOd);
		q.setParameter(5, datumOd);

		return q.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Collection<Parcela> findParcela2(String lastName, Integer katastr,
			Integer lv, String identifikatorSml) throws DataAccessException {
		Query q = this.em
				.createNativeQuery("select parcela from PARCELA par, Klient kl, PODIL pod, KATASTR kat, SMLOUVA sml, LV lv where "
						+ "par.lv.id=lv.id and kat.id=lv.katastr.id and lv.id=pod.lv.id and pod.klient.id=kl.id and kl.smlouvy.id=sml.id and"
						+ "(:lastName is null or kl.lastName like :lastname) and (:katastr is null or kat.kod = :katastr) and (:lv is null or lv.cislo=:lv) and "
						+ "(:identifikatorSml is null or sml.identifikator like :identifikatorSml");

		q.setParameter(1, lastName);
		q.setParameter(2, lastName);
		q.setParameter(3, katastr);
		q.setParameter(4, katastr);
		q.setParameter(5, lv);
		q.setParameter(6, lv);
		q.setParameter(7, identifikatorSml);
		q.setParameter(8, identifikatorSml);

		return q.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Collection<Parcela> findParcela(Integer id)
			throws DataAccessException {
		Query q = this.em
				.createNativeQuery("select parcela from PARCELA par, Klient kl, PODIL pod, KATASTR kat, PAR_VE_SML parsml, SMLOUVA sml, LV lv where "
						+ "par.lv.id=lv.id and kat.id=lv.katastr.id and lv.id=pod.lv.id and pod.klient.id=kl.id and kl.smlouvy.id=sml.id and parsml.parcela.id=par.id and parsml.klient.id=kl.id and "
						+ "parcela.id=:id");

		q.setParameter("id", id);

		return q.getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Collection<ListVlastnictvi> findLv(String lastName, Integer katastr,
			Integer cisloLv) throws DataAccessException {
		Query q = this.em
				.createNativeQuery("select lv from LV lv,PODIL pod, KATASTR kat, KLIENT kl where lv.id=pod.lv.id and pod.klient.id=kl.id and"
						+ "lv.katastr.id = kat.id and (:lastName is null or kl.lastName like :lastName) and (:katastr is null or kat.kod=:katastr) and "
						+ "(:cisloLV is null or lv.cislo=:cisloLv)");

		q.setParameter(1, lastName);
		q.setParameter(2, lastName);
		q.setParameter(3, katastr);
		q.setParameter(4, katastr);
		q.setParameter(5, cisloLv);
		q.setParameter(6, cisloLv);

		return q.getResultList();
	}

	public Collection<Katastr> findKatastr(String name, Integer kod)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Klient loadKlient(Integer id) throws DataAccessException {
		return this.em.find(Klient.class, id);
	}

	public Smlouva loadSmlouva(Integer id) throws DataAccessException {
		return this.em.find(Smlouva.class, id);
	}

	public Parcela loadParcela(Integer id) throws DataAccessException {
		return this.em.find(Parcela.class, id);
	}

	public ListVlastnictvi loadLv(Integer id) throws DataAccessException {
		return this.em.find(ListVlastnictvi.class, id);
	}

	public Katastr loadKatastr(Integer id) throws DataAccessException {
		return this.em.find(Katastr.class, id);
	}

	public void storeKlient(Klient klient) throws DataAccessException {
		Klient merged = this.em.merge(klient);
		this.em.flush();
		klient.setId(merged.getId());
	}

	public void storeParcela(Parcela parcela) throws DataAccessException {
		Parcela merged = this.em.merge(parcela);
		this.em.flush();
		parcela.setId(merged.getId());

	}

	public void storeLv(ListVlastnictvi lv) throws DataAccessException {
		ListVlastnictvi merged = this.em.merge(lv);
		this.em.flush();
		lv.setId(merged.getId());

	}

	public void storeKatastr(Katastr katastr) throws DataAccessException {
		Katastr merged = this.em.merge(katastr);
		this.em.flush();
		katastr.setId(merged.getId());

	}

	public void storeSmlouva(Smlouva smlouva) throws DataAccessException {
		Smlouva merged = this.em.merge(smlouva);
		this.em.flush();
		smlouva.setId(merged.getId());

	}

}
