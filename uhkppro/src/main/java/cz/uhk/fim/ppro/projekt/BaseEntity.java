package cz.uhk.fim.ppro.projekt;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class BaseEntity {

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	@Transient
	public boolean isNew() {
		return (this.id == null);
	}
}
