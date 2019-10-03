package com.apress.pss.acl.services;

import java.util.Collection;

import com.apress.pss.acl.domain.Post;

public interface ForumService {
	void createPost(Post post);

	public abstract Collection<Post> getPosts();

	public abstract void deletePost(Post post);
}
