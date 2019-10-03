package demo.grails

import grails.plugins.springsecurity.Secured;

class UnsecuredController {

	@Secured(["ROLE_USER"])
    def message() {
        render "message for everyone"    
    }
}
