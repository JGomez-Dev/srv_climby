package com.climbtogether.climby.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "/",tags = "Gestor de reservas")
@RequestMapping("/reservation")
public class ReservationController {

}