package com.example.getdiamond.models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserModel {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 private String name;
	    private String password;
	    private int money;
	    private int diamond;
	    private int ruby;
	    private int opal;
	    private int emerald;
	    private Date lastMining;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "id_jewerly1", nullable = true)
	    //@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private JewelryModel indent1;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "id_jewerly2", nullable = true)
	    //@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private JewelryModel indent2;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name = "id_jewerly3", nullable = true)
	    //@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private JewelryModel indent3;
	    
	    private int totalExchange;
	    private int totalBuilt;
		
	    public UserModel() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public int getDiamond() {
			return diamond;
		}

		public void setDiamond(int diamond) {
			this.diamond = diamond;
		}

		public int getRuby() {
			return ruby;
		}

		public void setRuby(int ruby) {
			this.ruby = ruby;
		}

		public int getOpal() {
			return opal;
		}

		public void setOpal(int opal) {
			this.opal = opal;
		}

		public int getEmerald() {
			return emerald;
		}

		public void setEmerald(int emerald) {
			this.emerald = emerald;
		}

		public Date getLastMining() {
			return lastMining;
		}

		public void setLastMining(Date lastMining) {
			this.lastMining = lastMining;
		}

		public JewelryModel getIndent1() {
			return indent1;
		}

		public void setIndent1(JewelryModel indent1) {
			this.indent1 = indent1;
		}

		public JewelryModel getIndent2() {
			return indent2;
		}

		public void setIndent2(JewelryModel indent2) {
			this.indent2 = indent2;
		}

		public JewelryModel getIndent3() {
			return indent3;
		}

		public void setIndent3(JewelryModel indent3) {
			this.indent3 = indent3;
		}

		public int getTotalExchange() {
			return totalExchange;
		}

		public void setTotalExchange(int totalExchange) {
			this.totalExchange = totalExchange;
		}

		public int getTotalBuilt() {
			return totalBuilt;
		}

		public void setTotalBuilt(int totalBuilt) {
			this.totalBuilt = totalBuilt;
		}

		
}
