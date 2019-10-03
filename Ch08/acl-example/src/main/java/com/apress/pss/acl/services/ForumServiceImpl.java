package com.apress.pss.acl.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.apress.pss.acl.domain.Post;

@Service
public class ForumServiceImpl implements ForumService {
	@Autowired
	private MutableAclService mutableAclService;
	private Map<Integer, Post> postStore = new HashMap<Integer, Post>();

	@Transactional
	public void createPost(Post post) {
		Integer id = new Integer(Math.abs(post.hashCode()));
		ObjectIdentity oid = new ObjectIdentityImpl(Post.class, id);
		MutableAcl acl = mutableAclService.createAcl(oid);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("currentUser", user.getUsername());
		modelAndView.addObject("role", user.getAuthorities());
		modelAndView.addObject("adminMessage", "Content Available only for Authenticated Admins!");


		acl.insertAce(0, BasePermission.ADMINISTRATION, new PrincipalSid(
				user.getUsername()), true);
		acl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(
				"ROLE_ADMIN"), true);
		if(isAdminUserLogged()){
			acl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid(
					"ROLE_ADMIN"), true);
		}else{
		acl.insertAce(2, BasePermission.READ, new GrantedAuthoritySid(
				"ROLE_USER"), true);
		}
		mutableAclService.updateAcl(acl);
		post.setId(id);
		postStore.put(id, post);
	}
	

	@Transactional
	@Secured("ACL_POST_DELETE")
	public void deletePost(Post post){
		ObjectIdentity oid = new ObjectIdentityImpl(Post.class, post.getId());
		mutableAclService.deleteAcl(oid, true);
		postStore.remove(postStore.get(post.getId()));
	}
	
	//@PostFilter("hasPermission(filterObject, 'READ')")
	public Collection<Post> getPosts(){
		return new ArrayList<Post>(postStore.values());
	}

	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}
	
	private boolean isAdminUserLogged() {
		for(GrantedAuthority authority: SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
			if(authority.getAuthority().equals("ROLE_ADMIN")){
				return true;
			}
		}
		return false;
	}

}
