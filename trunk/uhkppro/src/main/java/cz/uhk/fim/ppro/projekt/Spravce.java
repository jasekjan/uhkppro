package cz.uhk.fim.ppro.projekt;

import java.sql.Date;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

public interface Spravce {
	Collection<Klient> getKlienti() throws DataAccessException;
	Collection<Parcela> getParcely() throws DataAccessException;
	Collection<ListVlastnictvi> getListyVlastnictvi() throws DataAccessException;
	Collection<Katastr> getKatastry() throws DataAccessException;
	Collection<Smlouva> getSmlouvy() throws DataAccessException;
	
	Collection<Klient> findKlient(String lastName) throws DataAccessException;
	Collection<Smlouva> findSmlouva(String lastName, String identifikator, Date datumOd) throws DataAccessException;
	Collection<Parcela> findParcela2(String lastName, Integer katastr, Integer lv, String identifikatorSml) throws DataAccessException;
	Collection<Parcela> findParcela(Integer id) throws DataAccessException;
	Collection<ListVlastnictvi> findLv(String lastName, Integer katastr, Integer cisloLv) throws DataAccessException;
	Collection<Katastr> findKatastr(String name, Integer kod) throws DataAccessException;
		
	Klient loadKlient(Integer id) throws DataAccessException;
	Smlouva loadSmlouva(Integer id) throws DataAccessException;
	Parcela loadParcela(Integer id) throws DataAccessException;
	ListVlastnictvi loadLv(Integer id) throws DataAccessException;
	Katastr loadKatastr(Integer id) throws DataAccessException;
	
	void storeKlient(Klient klient) throws DataAccessException;
	void storeParcela(Parcela parcela) throws DataAccessException;
	void storeLv(ListVlastnictvi lv) throws DataAccessException;
	void storeKatastr(Katastr katastr) throws DataAccessException;
	void storeSmlouva(Smlouva smlouva) throws DataAccessException;

}
