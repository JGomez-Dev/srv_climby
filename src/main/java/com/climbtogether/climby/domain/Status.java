package com.climbtogether.climby.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "tb_status")
public class Status  implements Serializable {

	private static final long serialVersionUID = -6530045574412000097L;
	
	@Id
	@SequenceGenerator(name = "idStatusSeqGenerator", sequenceName = "sc_status", allocationSize = 1)
	@GeneratedValue(generator = "idStatusSeqGenerator")
	@Column(name = "id_status",unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "status_reservation")
	private boolean reservationStatus;
	
	@Column(name = "status_valuation")
	private boolean valuationStatus;
	

}
