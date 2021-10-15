package com.climbtogether.climby.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_travel")
public class Travel  implements Serializable {
	
	private static final long serialVersionUID = 728241147126109829L;

	@Id
	@SequenceGenerator(name = "idTravelSeqGenerator", sequenceName = "sc_travel", allocationSize = 1)
	@GeneratedValue(generator = "idTravelSeqGenerator")
	@Column(name = "id_travel",unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_driver", foreignKey = @ForeignKey(name = "fk_driver"))
	private User driver;
	
	@Column(name = "site", nullable = false)
	private String site;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "available_places", nullable = false)
	private Integer availablePlaces;

	
	@Column(name = "departure_date_string", nullable = false)
	private String departureDateString;
	
	@Column(name = "departure_date", nullable = false)
	private LocalDateTime departureDate;
	
	@OneToOne
	@JoinColumn(name = "province", nullable = false)
	private Province province;
	

	@OneToMany(mappedBy = "passenger",fetch = FetchType.EAGER, cascade = {CascadeType.ALL},orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Reservation> reservation;
	
	
}
