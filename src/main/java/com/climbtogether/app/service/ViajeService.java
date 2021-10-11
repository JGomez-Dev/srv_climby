package com.climbtogether.app.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.climbtogether.app.entity.*;

import com.climbtogether.app.dao.*;

@Service
public class ViajeService {

	@Autowired
	private ViajeRepository viajeRepository;

	// Metodo que muestra viaje por id:
	public Optional<Viaje> findById(Integer id) {
		return viajeRepository.findById(id);
	}

	// Metodo que muestra viaje por id:
	public Optional<Viaje> findById2(Integer id) {
		return viajeRepository.findById(id);
	}

	// Metodo que muestra todos los viajes:
	public List<Viaje> findAll() {
		return viajeRepository.findAll();
	}

	// Metodo que muestra todos los viajes:
	public Viaje getLastTravel(Integer id_pasajero) {
		return viajeRepository.getLastTravel(id_pasajero);
	}

	// Metodo para eliminar un Viaje:
	public Viaje delete(Viaje viaje) {
		viajeRepository.delete(viaje);
		return null;
	}

	// Metodo para eliminar un Viaje por id:
	public Viaje deleteById(Integer id) {
		viajeRepository.deleteById(id);
		return null;
	}

	// Metodo para actualizar viaje por id (Num plazas)
	public Viaje save(Viaje viaje) {
		Date date = new Date(); // given date
		String anno = date.toString().split(" ")[(date.toString().split(" ")).length - 1];
		String horaZona = date.toString().split(" ")[3] + " " + date.toString().split(" ")[4];
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		try {
			Date auxFecha = form.parse(anno + "-" + viaje.getFechasalidaString().split("/")[1] + "-"
					+ viaje.getFechasalidaString().split("/")[0] + " " + horaZona);
			//viaje.setFechasalida(auxFecha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viajeRepository.save(viaje);
	}

//	// Metodo para actualizar viaje por id (Num plazas)
//		public Optional<Viaje> update(Viaje viaje) {
//			Date date = new Date();   // given date
//	 		String anno = date.toString().split(" ")[(date.toString().split(" ")).length-1];
//			String horaZona = date.toString().split(" ")[3]+" "+date.toString().split(" ")[4];
//			SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//			try {
//				Date auxFecha = form.parse(anno+"-"+viaje.getFechasalidaString().split("/")[1]+"-"+viaje.getFechasalidaString().split("/")[0]+" "+ horaZona);
//				viaje.setFechasalida(auxFecha);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return viajeRepository.update(viaje.getId(), viaje.getConductor().getIdusuario());
//		}
//	
	// Metodo para obtener una lista con los viajes de ese dia y luego tratarla, no
	// obtiene los viajes que pertenecen al mismo usuario:
	public List<Viaje> muestraViajeDelDia(int id, java.util.Date fecha, BigDecimal precio) {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String auxFechaIni = form.format(fecha);
		String auxFechaFin = form.format(fecha).substring(0, 10) + " 23:59:59";
		return viajeRepository.mostrarViajesDelDia(auxFechaIni, auxFechaFin, precio, id);
	}

	// Metodo para obtener una lista con los viajes publicados por el usuario:
	public List<Viaje> muestraViajesPublicados(Integer idUsuario) {
		return viajeRepository.mostrarViajesPublicados(idUsuario);
	}

	public List<Viaje> mostrarViajesConReservas() {
		return viajeRepository.mostrarViajesConReservas();
	}

}