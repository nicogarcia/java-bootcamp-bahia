package com.globant.app.domain.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@MappedSuperclass
public abstract class User implements UserDetails {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;
	private String password;

	private boolean enabled;
	private boolean expired;
	private boolean locked;
	private boolean credentialsExpired;

	// TODO: Implement authorities list
	@Transient
	private Collection<? extends GrantedAuthority> authorities;

	public User() {
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		authorities.add(authority);

		return authorities;
	}

	@Override public String getPassword() {
		return password;
	}

	@Override public String getUsername() {
		return username;
	}

	@Override public boolean isAccountNonExpired() {
		return !expired;
	}

	@Override public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Override public boolean isEnabled() {
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
