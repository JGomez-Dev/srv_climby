package com.climbtogether.app.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.climbtogether.app.entity.Reserva;
import com.climbtogether.app.entity.ReservaId;
import com.climbtogether.app.entity.Viaje;
import com.climbtogether.app.service.ReservaService;
import com.climbtogether.app.service.ViajeService;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private ViajeService viajeService;
	//
	
	//Consulta todas las reservas
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAll() {
		List<Reserva> vOpt = reservaService.findAll();
		if (vOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vOpt);

	}

	// Lee un reserva por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<List<Reserva>>> findById(@PathVariable("id") Integer id) {
		Optional<List<Reserva>> reOptional = reservaService.findByIdList(id);
		if (reOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(reOptional);

	}
	
	// Lee un reserva por id de viaje
	@RequestMapping(value = "porIdViaje/{viajeId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<List<Reserva>>> findByViajeId(@PathVariable("viajeId") Integer viajeId) {
		Optional<List<Reserva>> reOptional = reservaService.muestraReservasPorIdViaje(viajeId);
		if (reOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(reOptional);

	}


	// Elimina un reserva
	@RequestMapping(value = "rechazarReserva/{idViaje}/{idPasajero}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable("idViaje") Integer idViaje, @PathVariable("idPasajero") Integer idPasajero){
		reservaService.deleteById(idViaje, idPasajero);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	// Crea un reserva
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Reserva reserva) {
		Optional<Viaje> vOpt = viajeService.findById(reserva.getViajeId());
		Reserva r = new Reserva();
		ReservaId ri = new ReservaId();
		ri.setIdPasajero(reserva.getPasajero().getIdusuario());
		ri.setIdviaje(vOpt.get().getId());
		r.setId(ri);
		r.setFechareserva(new Timestamp(System.currentTimeMillis()));
		r.setViaje(vOpt.get());
		r.setEstadoReserva((byte)1);
		r.setEstadoValoracion((byte)1);
		r.setViajeId(reserva.getViajeId());
		r.setPasajero(reserva.getPasajero());
		/*Optional<Reserva> reOptional = reservaService.findById(reserva.getId().getIdreserva());
		if (!reOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}*/

		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(r));

	}

	// Actualiza un reserva
	@RequestMapping(value = "aceptarReserva", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Reserva reservaDetails) {
		return ResponseEntity.status(HttpStatus.OK).body(reservaService.save(reservaDetails));
	}
	

	@RequestMapping(value = "/findAllConReservas", method = RequestMethod.GET)
	public ResponseEntity<List<?>> findAllConReservas() {
		List<Viaje> vOpt = viajeService.mostrarViajesConReservas();
		if (vOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vOpt);

	}

//	//MOSTRAR RESERVAS POR IDUSUARIO
//	 	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET)
//		public ResponseEntity <List<ReservaConIgnore>> consultaReservasPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
//	 		Optional <List<Reserva>> listOpt=reservaService.muestraReservasPorIdUsuario(idUsuario);
//	 		if(listOpt.isPresent()) {
//				List<ReservaConIgnore> listFinal = new ArrayList<ReservaConIgnore>();
//				for (int i=0 ; i<listOpt.get().size() ; i++) {
//					ReservaConIgnore rIg = new ReservaConIgnore();
//					rIg.setFechareserva(listOpt.get().get(i).getFechareserva());
//					rIg.setId(listOpt.get().get(i).getId());
//					rIg.setUsuario(listOpt.get().get(i).getPasajero());
//					rIg.setViaje(listOpt.get().get(i).getViaje());
//					listFinal.add(rIg);
//				}
//	 			return new ResponseEntity<List<ReservaConIgnore>>(listFinal, HttpStatus.OK);
//	 		}else {
//	 			return new ResponseEntity<List<ReservaConIgnore>>(HttpStatus.NOT_FOUND);
//	 		}	
//		}
//	 	
//	 	//MOSTRAR RESERVAS POR IDVIAJE
//	 	@RequestMapping(value = "/IdViaje/{idViaje}", method = RequestMethod.GET)
//		public ResponseEntity <List<ReservaConIgnore>> consultaReservasPorIdViaje(@PathVariable("idViaje") Integer idViaje) {
//	 		Optional <List<Reserva>> listOpt=reservaService.muestraReservasPorIdViaje(idViaje);
//	 		if(listOpt.isPresent()) {
//				List<ReservaConIgnore> listFinal = new ArrayList<ReservaConIgnore>();
//				for (int i=0 ; i<listOpt.get().size() ; i++) {
//					ReservaConIgnore rIg = new ReservaConIgnore();
//					rIg.setFechareserva(listOpt.get().get(i).getFechareserva());
//					rIg.setId(listOpt.get().get(i).getId());
//					rIg.setUsuario(listOpt.get().get(i).getPasajero());
//					rIg.setViaje(listOpt.get().get(i).getViaje());
//					listFinal.add(rIg);
//				}
//	 			return new ResponseEntity<List<ReservaConIgnore>>(listFinal, HttpStatus.OK);
//	 		}else {
//	 			return new ResponseEntity<List<ReservaConIgnore>>(HttpStatus.NOT_FOUND);
//	 		}	
//		}
	 	
//	 	//ELIMINAR RESERVA POR IDVIAJE E IDPASAJERO
//		@RequestMapping(value = "/eliminarReservaIdViajeIdPasajero/{idViaje}/{idPasajero}", method = RequestMethod.DELETE)//Asociamos la petición recibida la metodo de respuesta
//		public ResponseEntity<Reserva> eliminarReservaIdViajeIdPasajero(@PathVariable("idViaje") Integer idViaje, @PathVariable("idPasajero") Integer idPasajero) {
//			//Obtenemos el viaje e usuario por el cual borrar:
//	 		Optional<Usuario>uOpt=usuarioService.consultaUsuarioPorId(idPasajero);
//	 		Optional<Viaje>vOpt=viajeService.findById(idViaje);
//	 		//Si estan presentes seguimos, si no devolvemos error de mal solicitud:
//	 		if(vOpt.isPresent()&&vOpt.isPresent()) {
//	 			//Comprobamos que el viaje del cual se va a cancelar la reserva no este caducado, sino se devuelve error 404:
//	            Date fechaViaje = vOpt.get().getFechasalida();
//	            Date fechaActual = new java.util.Date(Calendar.getInstance().getTime().getTime());
//	            if (fechaViaje.compareTo(fechaActual) > 0) {
//	                //Borramos la reserva de ese viaje y de ese usuario:
//	            	reservaService.eliminarReservaIdViajeIdPasajero(idViaje, idPasajero);
//	            	//Liberamos la plaza no reservada, aumentando una mas:
//	            	int plazas = vOpt.get().getNumplazasdisponibles()+1;
//	            	vOpt.get().setNumplazasdisponibles(plazas);
//	            	viajeService.actualizaViaje(vOpt.get());
//	            	return new ResponseEntity<>(null,HttpStatus.OK);
//	            }else {
//	            	return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//	            }
//	 		}else {
//	 			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
//	 		}
//	 		
//		}
	
}
