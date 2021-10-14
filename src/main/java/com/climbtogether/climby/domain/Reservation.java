package com.climbtogether.climby.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 6936124757433460309L;

	@Id
	@SequenceGenerator(name = "idReservationSeqGenerator", sequenceName = "sc_reservation", allocationSize = 1)
	@GeneratedValue(generator = "idReservationSeqGenerator")
	@Column(name = "id_reservation",unique = true, nullable = false)
	private String id;

	@ManyToOne
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "fk_passenger"))
	private User passenger;

	@ManyToOne
	@JoinColumn(name = "id_travel", foreignKey = @ForeignKey(name = "fk_travel"))
	private Travel travel;

	@Column(name = "id_status", nullable = false)
	private Status status;

	@Column(name = "date_reservation", nullable = false)
	private LocalDateTime reservationDate;

}
