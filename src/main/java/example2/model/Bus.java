package example2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus implements Serializable {
	/**
	 * Require in order to prevent the IDE warning
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	@Basic(optional = false)
	@Column(nullable = false)
	private String name;

	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bus",cascade=CascadeType.ALL)
	private List<Seat> seats = new ArrayList<>();

	@ToString.Exclude
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "busses")
	private List<BussDriver> bussDrivers = new ArrayList<>();;
}
