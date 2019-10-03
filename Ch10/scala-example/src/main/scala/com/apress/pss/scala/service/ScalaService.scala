package com.apress.pss.scala.service;
import org.springframework.stereotype.Service
import org.springframework.security.access.annotation.Secured

trait ScalaServiceFacade { 
	def scalaService: String
}

class ScalaService extends ScalaServiceFacade{
  @Secured(Array("ROLE_USER"))
  def scalaService() = "Service accessed"
}