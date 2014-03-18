package cz.uhk.fim.ppro.projekt;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="KLIENTI")
public class Klient extends BaseEntity{

	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String phoneContact;
	private String email;
	private Set<Podil> podily;
	private Set<Smlouva> smlouvy;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(fetch=FetchType.EAGER, mappedBy="klient")
	public Set<Smlouva> getSmlouvy() {
		return smlouvy;
	}
	public void setSmlouvy(Set<Smlouva> smlouvy) {
		this.smlouvy = smlouvy;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhoneContact() {
		return phoneContact;
	}
	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy="klient")
	public Set<Podil> getPodily() {
		return podily;
	}
	public void setPodily(Set<Podil> podily) {
		this.podily = podily;
	}
	
	@Override
	public String toString() {
		return this.getLastName()  +' '+this.getFirstName()+'(' + this.getCity() + ')';
	}
	
}
