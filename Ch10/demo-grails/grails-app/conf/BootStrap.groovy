import demo.security.Role
import demo.security.User
import demo.security.UserRole

class BootStrap {

    def init = { servletContext ->
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
  
		def testAdmin = new User(username: 'carlo', enabled: true, password: 'password')
		testAdmin.save(flush: true)
		def testUser = new User(username: 'monica', enabled: true, password: 'password')
		testUser.save(flush: true)
  
		UserRole.create testAdmin, adminRole, true
		UserRole.create testUser, userRole, false

    }
    def destroy = {
    }
}
