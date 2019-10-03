package demo.grails

import grails.plugins.springsecurity.Secured;

class SecuredController {

	@Secured(["ROLE_ADMIN"])
    def message() {
        render "Incredibly confidential message"    
    }
}
