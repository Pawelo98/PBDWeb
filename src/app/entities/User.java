package app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Users")
public class User {
	
		public enum Role { admin, administrative, physical };

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Id")
		private int user_id;
		
		@Column(name="Login")
		private String login;
		
		@Column(name="Password")
		private String password;
		
		@Temporal(TemporalType.DATE)
		@Column(name="Registration_date")
		private Date registrationDate;
		
		@Column(name="Name")
		private String name;
		
		@Column(name="Surname")
		private String surname;
		
		@Column(name="Role")
		@Enumerated(EnumType.STRING)
		private Role role;
		
		@Column(name="Address")
		private String address;
		
		@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH})
		@JoinColumn(name="Club")
		private Club club;
		
		public User() {
			
		}
		
		public User(String loginG, String passwordG, Date dateG, String nameG, String surnameG, String roleG, String addressG) {
			this.login = loginG;
			this.password = passwordG;
			this.registrationDate = dateG;
			this.name = nameG;
			this.surname = surnameG;
			this.role = Role.valueOf(roleG);
			this.address = addressG;
		}

		

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}


		public Club getClub() {
			return club;
		}

		public void setClub(Club club) {
			this.club = club;
		}

		@Override
		public String toString() {
			return "User [user_id=" + user_id + ", login=" + login + ", password=" + password + ", registrationDate="
					+ registrationDate + ", name=" + name + ", surname=" + surname + ", role=" + role + ", address="
					+ address + ", club=" + club + "]";
		}

		
}
