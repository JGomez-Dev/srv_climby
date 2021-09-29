package com.climbtogether.app.controller;

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
import com.climbtogether.app.entity.Usuario;
import com.climbtogether.app.entity.Viaje;
import com.climbtogether.app.service.ReservaService;
import com.climbtogether.app.service.UsuarioService;
import com.climbtogether.app.service.ViajeService;

import clasesviajespublicados.Pasajero;
import clasesviajespublicados.ViajePublicado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trips")
@CrossOrigin
public class ViajeController {

	@Autowired
	private ViajeService viajeService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ReservaService reservaService;

	// CONSULTA TODOS LOS VIAJES
	@RequestMapping(value = "/",method = RequestMethod.GET)	
	public ResponseEntity<List<?>> findAll() {
		List<Viaje> vOpt = viajeService.findAll();
		if (vOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vOpt);
//
	}
	
	@RequestMapping(value = "/LastTravel/{id_pasajero}", method = RequestMethod.GET)
	public ResponseEntity<?> getLastTravel(@PathVariable("id_pasajero")Integer id_pasajero) {
		Viaje vOpt = viajeService.getLastTravel(id_pasajero);
		if (vOpt != null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vOpt);

	}

	// Lee un viaje
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		Optional<Viaje> viaje = viajeService.findById(id);
		if (!viaje.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(viaje);

	}

	// Elimina un viaje
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		if (!viajeService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		viajeService.deleteById(id);
		return ResponseEntity.ok().build();

	}

	// Crea un viaje
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Viaje viaje) {
		Optional<Usuario> vOpt = usuarioService.findById(viaje.getConductor().getIdusuario());
		if (!vOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		try {
			return new ResponseEntity<>(viajeService.save(viaje), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

//	// Actualiza un viaje
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Viaje viajeDetails) {
//		Optional<Viaje> vOpt = viajeService.findById(id);
//		if (!vOpt.isPresent()) {
//			return ResponseEntity.notFound().build();
//
//		} else {
//			vOpt.get().setConductor(viajeDetails.getConductor());
//			vOpt.get().setFechasalida(viajeDetails.getFechasalida());
//			vOpt.get().setLugar(viajeDetails.getLugar());
//			vOpt.get().setNumplazasdisponibles(viajeDetails.getNumplazasdisponibles());
//			vOpt.get().setReservas(viajeDetails.getReservas());
//			return new ResponseEntity<>(viajeService.update(vOpt), HttpStatus.OK);
//		}
//
//	}


//	//REGISTRAR VIAJE
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<ViajeConIgnore> registraViaje(@RequestBody Map<String, String> param) {
// 		Integer auxIdConductor=Integer.parseInt(param.get("conductor"));
// 		Optional<Usuario>uOptConductor=usuarioService.get(auxIdConductor);
// 		ViajeConIgnore vError=new ViajeConIgnore();
// 		if(uOptConductor.isPresent()) {
//			String auxLugar=param.get("lugar");
//			int auxNumPlazas=Integer.parseInt(param.get("numplazasdisponibles"));
////			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////			java.util.Date auxFecha=null;
////			try {
////				auxFecha = form.parse(param.get("fechasalida"));
////			} catch (java.text.ParseException e) {
////			// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//			Viaje v=new Viaje();
//			v.setConductor(uOptConductor.get());
//			v.setNumplazasdisponibles(auxNumPlazas);
////			v.setFechasalida(auxFecha);
//			
//			ViajeConIgnore vI=new ViajeConIgnore();
//			vI.setConductor(v.getConductor());
//			vI.setNumplazasdisponibles(v.getNumplazasdisponibles());
//			vI.setFechasalida(v.getFechasalida());
//			return new ResponseEntity<>(vI, HttpStatus.OK);
// 		}else {
// 			vError.setUsuarioError("El usuario no existe");
// 			return new ResponseEntity<ViajeConIgnore>(vError,HttpStatus.NOT_FOUND);	
// 		}
//	}

	// CONSULTAR LOS VIAJES PUBLICADOS QUE EL USUARIO HA PUBLICADO A LO LARGO DEL
	// TIEMPO(NO SE FILTRA POR PRESENTE O PASADO)
	@RequestMapping(value = "/PorIdConductor/{idConductor}", method = RequestMethod.GET)
	public ResponseEntity<List<ViajePublicado>> consultaViajesPublicados(@PathVariable("idConductor") Integer idConductor) {
		List<Viaje> listViajes = viajeService.muestraViajesPublicados(idConductor);
		List<ViajePublicado> listFinal = new ArrayList<ViajePublicado>();
		if (!listViajes.equals(null) && !listViajes.isEmpty()) {
			for (int i = 0; i < listViajes.size(); i++) {
				Optional<List<Reserva>> listOptReser = reservaService
						.muestraReservasPorIdViaje(listViajes.get(i).getId());
				if (listOptReser.isPresent()) {
					List<Pasajero> pasajerosList = new ArrayList<Pasajero>();
					for (int j = 0; j < listOptReser.get().size(); j++) {
						Optional<Usuario> uOpt = usuarioService
								.findById(listOptReser.get().get(j).getId().getIdPasajero());
						if (uOpt.isPresent()) {
							pasajerosList.add(new Pasajero(uOpt.get().getIdusuario(), uOpt.get().getNombreCompleto(),
									uOpt.get().getTelefono(), uOpt.get().getEmail(), uOpt.get().getFotousuario()));
						}
					}
					listFinal.add(new ViajePublicado(listViajes.get(i).getId(), listViajes.get(i).getConductor(),
							listViajes.get(i).getLugar(), listViajes.get(i).getNumplazasdisponibles(),
							listViajes.get(i).getFechasalida(), pasajerosList));
				} else {
					listFinal.add(new ViajePublicado(listViajes.get(i).getId(), listViajes.get(i).getConductor(),
							listViajes.get(i).getLugar(), listViajes.get(i).getNumplazasdisponibles(),
							listViajes.get(i).getFechasalida(), new ArrayList<Pasajero>()));
				}
			}
			return new ResponseEntity<List<ViajePublicado>>(listFinal, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ViajePublicado>>(HttpStatus.NOT_FOUND);
		}
	}
//		//REGISTRAR VIAJE
//		@RequestMapping(value = "/registrarViaje", method = RequestMethod.POST)
//		public ResponseEntity<ViajeConIgnore> registraViaje(@RequestBody Map<String, String> param) {
//	 		Integer auxIdUsuario=Integer.parseInt(param.get("idUsuario"));
//	 		Optional<Usuario>uOpt=usuarioService.consultaUsuarioPorId(auxIdUsuario);
//	 		ViajeConIgnore vError=new ViajeConIgnore();
//	 		if(uOpt.isPresent()) {
//
// 					String auxLugar=param.get("lugar");
// 	 				int auxNumPlazas=Integer.parseInt(param.get("numPlazas"));
// 	 				SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// 	 				java.util.Date auxFecha=null;
//					try {
//						auxFecha = form.parse(param.get("fecha"));
//					} catch (java.text.ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
// 	 				Double precioAux= Double.valueOf(param.get("precio"));
// 	 				BigDecimal auxPrecio=BigDecimal.valueOf(precioAux);
// 	 				Viaje v=new Viaje();
// 	 				v.setUsuario(uOpt.get());
// 	 				v.setNumplazasdisponibles(auxNumPlazas);
// 	 				v.setFechasalida(auxFecha);
// 	 				
// 	 				ViajeConIgnore vI=new ViajeConIgnore();
// 	 				vI.setUsuario(v.getUsuario());
// 	 				vI.setNumplazasdisponibles(v.getNumplazasdisponibles());
// 	 				vI.setFechasalida(v.getFechasalida());
// 	 				return new ResponseEntity<>(vI, HttpStatus.OK);
//				
//	 		}else {
//	 			vError.setUsuarioError("El usuario no existe");
//	 			return new ResponseEntity<ViajeConIgnore>(vError,HttpStatus.NOT_FOUND);	
//	 		}
//		}
//		
//		//CONSULTAR VIAJE FILTRANDO POR FECHA, LOCALIDAD ORIGEN Y DESTINO, PRECIO ...
//	 	@RequestMapping(value="/consultaViajesReservar", method=RequestMethod.POST)
//		public ResponseEntity<List<Viaje>> consultaViajesReservar(@RequestBody Map<String, String> param){
//	 		
//	 		if(!param.get("idUsuario").equals(null)&&!param.get("localidadOrigen").equals(null) && !param.get("lugarSalida").equals(null) 
//	 			&& !param.get("localidadDestino").equals(null) && !param.get("lugarLlegada").equals(null)
//	 			&& !param.get("fechaSalida").equals(null) && !param.get("precioMax").equals(null)) {
//	 			
//	 			int id = Integer.parseInt(param.get("idUsuario"));
//	 			String auxLocalidadOrigen=param.get("localidadOrigen");
//	 			String auxLugarSalida=param.get("lugarSalida");
//	 			String auxLocalidadDestino=param.get("localidadDestino");
//	 			String auxLugarLlegada=param.get("lugarLlegada");
//	 			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				java.util.Date auxFechaSalida=null;
//				try {
//					auxFechaSalida = form.parse(param.get("fechaSalida"));
//				} catch (java.text.ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				Double precioAux= Double.valueOf(param.get("precioMax"));
//				BigDecimal auxPrecio=BigDecimal.valueOf(precioAux);
//				
//	 			List<Viaje> listaOriginal=viajeService.muestraViajeDelDia(id,auxFechaSalida,auxPrecio);
//	 			//Filtramos la lista por localidad de origen y de destino:
//	 			for (int i = 0; i < listaOriginal.size(); i++) {
//					
//				}
//	 			//Filtremos los viajes que el usuario ya ha reservado una vez
//	 			for (int i = 0; i < listaOriginal.size(); i++) {
//	 				Optional<Reserva>rOpt=reservaService.muestraReservaPorIdUsuarioYidViaje(id,listaOriginal.get(i).getIdviaje());
//					if(rOpt.isPresent()) {
//						listaOriginal.remove(i);
//						i--;
//					}
//				}
//	 			//Limpiamos ciertos atributos para evitar la recursividad y por privacidad:
//	 			for(Viaje v: listaOriginal) {
//	 				v.getUsuario().setReservas(null);
//	 				v.getUsuario().setViajes(null);
//	 			}
//	 			//Ordenamos la lista por lugar de origen y de destino:
//	 			int i = 0;
//	 			List<Viaje> listaFinal = new ArrayList<Viaje>();
//	 			while(!listaOriginal.isEmpty()) {
//	 				listaFinal.add(listaOriginal.remove(0));
//	 			}
//	 			return new ResponseEntity<List<Viaje>>(listaFinal,HttpStatus.OK);
//	 		}else {
//	 			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//	 		}
//		}

//	 	
//	 	
//		//CONSULTAR LOS VIAJES QUE EL USUARIO HA RESERVADO A LO LARGO DEL TIEMPO(NO SE FILTRA POR PRESENTE O PASADO)
//	 	@RequestMapping(value="/consultarViajesReservadosPorIdUsuario/{idUsuario}", method=RequestMethod.GET)
//		public ResponseEntity<List<Viaje>> consultaViajesReservados(@PathVariable("idUsuario") Integer idUsuario){
//			Optional <List<Reserva>> listOpt=reservaService.muestraReservasPorIdUsuario(idUsuario);
//			if(listOpt.isPresent()) {
//				List<Viaje> listFinal = new ArrayList<Viaje>();
//				for (int i=0 ; i<listOpt.get().size() ; i++) {
//					Optional<Viaje> vOpt = viajeService.findById(listOpt.get().get(i).getId().getIdviaje());
//					if(vOpt.isPresent()) {
//						Viaje vF = new Viaje();
//						vF.setFechasalida(vOpt.get().getFechasalida());
//						vF.setIdviaje(vOpt.get().getIdviaje());
//						vF.setNumplazasdisponibles(vOpt.get().getNumplazasdisponibles());
//						vF.setReservas(null);
//						vF.setUsuario(vOpt.get().getUsuario());;
//		 				vF.getUsuario().setReservas(null);
//		 				vF.getUsuario().setViajes(null);
//		 				listFinal.add(vF);
//					}
//				}
//				return new ResponseEntity<List<Viaje>>(listFinal, HttpStatus.OK);
//			}else {
//				return new ResponseEntity<List<Viaje>>(HttpStatus.NOT_FOUND);
//			}
//		}

//	 

}
