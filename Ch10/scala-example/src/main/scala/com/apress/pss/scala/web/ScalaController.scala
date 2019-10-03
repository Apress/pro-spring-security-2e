package com.apress.pss.scala.web;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.stereotype.Controller
import com.apress.pss.scala.service.ScalaServiceFacade
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
 
@RequestMapping(Array("/enter"))
class ScalaController(service: ScalaServiceFacade) {

   @RequestMapping(value = Array("/scala"), method = Array(RequestMethod.GET))
   def scalaRequest(request:HttpServletRequest, response:HttpServletResponse) = {
    val value = service.scalaService 
    response.getWriter().write(value)
   }
}