package cz.uhk.fim.ppro.projekt.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.fim.ppro.projekt.Katastr;
import cz.uhk.fim.ppro.projekt.Klient;
import cz.uhk.fim.ppro.projekt.ListVlastnictvi;
import cz.uhk.fim.ppro.projekt.Parcela;
import cz.uhk.fim.ppro.projekt.ParcelaSmlouva;
import cz.uhk.fim.ppro.projekt.Smlouva;
import cz.uhk.fim.ppro.projekt.Spravce;

/**
 * A simple JDBC-based implementation of the {@link Clinic} interface.
 *
 * <p>This class uses Java 5 language features and the {@link SimpleJdbcTemplate}
 * plus {@link SimpleJdbcInsert}. It also takes advantage of classes like
 * {@link BeanPropertySqlParameterSource} and
 * {@link ParameterizedBeanPropertyRowMapper} which provide automatic mapping
 * between JavaBean properties and JDBC parameters or query results.
 *
 * <p>SimpleJdbcClinic is a rewrite of the AbstractJdbcClinic which was the base
 * class for JDBC implementations of the Clinic interface for Spring 2.0.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Sam Brannen
 * @author Thomas Risberg
 * @author Mark Fisher
 */
@Service
public class SimpleJdbcSpravce implements Spravce {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	public Collection<Klient> getKlienti() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Parcela> getParcely() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<ListVlastnictvi> getListyVlastnictvi()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Katastr> getKatastry() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Smlouva> getSmlouvy() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Klient> findKlienti(String lastName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Smlouva> findSmlouva(String lastName,
			String identifikator, Date datumOd) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Parcela> findParcela2(String lastName, Integer katastr,
			Integer lv, String identifikatorSml) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Parcela> findParcela(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<ListVlastnictvi> findLv(String lastName, Integer katastr,
			Integer cisloLv) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Katastr> findKatastr(String name, Integer kod)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Klient loadKlient(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Smlouva loadSmlouva(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Parcela loadParcela(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public ListVlastnictvi loadLv(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Katastr loadKatastr(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public void storeKlient(Klient klient) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	public void storeParcela(Parcela parcela) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	public void storeLv(ListVlastnictvi lv) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	public void storeKatastr(Katastr katastr) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	public void storeSmlouva(Smlouva smlouva) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	public Collection<ParcelaSmlouva> getParcelaSmlovuy()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public void storeParcelaSmlouva(ParcelaSmlouva parSml)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


}
