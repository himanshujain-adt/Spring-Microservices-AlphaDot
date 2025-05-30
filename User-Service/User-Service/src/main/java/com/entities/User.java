package com.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user-microservices")
public class User {
	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "about")
	private String about;
	@Transient
	private List<Rating> ratings = new ArrayList<>();

}
