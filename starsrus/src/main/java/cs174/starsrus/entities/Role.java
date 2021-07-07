package cs174.starsrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = DBTables.TABLE_ROLE.TABLENAME)
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DBTables.TABLE_ROLE.ATTR_ROLE_ID, length = 50)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = DBTables.TABLE_ROLE.ATTR_ROLE_NAME, length = 50)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}