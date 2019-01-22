package com.example.getdiamond.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class JewelryModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		private int ruby;
		private int emerald;
		private int diamond;
		private int opal;
	    private int gain;
	    private int resale;
	    private boolean build = false;
	    
		public JewelryModel() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getRuby() {
			return ruby;
		}

		public void setRuby(int ruby) {
			this.ruby = ruby;
		}

		public int getEmerald() {
			return emerald;
		}

		public void setEmerald(int emerald) {
			this.emerald = emerald;
		}

		public int getDiamond() {
			return diamond;
		}

		public void setDiamond(int diamond) {
			this.diamond = diamond;
		}

		public int getOpal() {
			return opal;
		}

		public void setOpal(int opal) {
			this.opal = opal;
		}

		public int getGain() {
			return gain;
		}

		public void setGain(int gain) {
			this.gain = gain;
		}

		public int getResale() {
			return resale;
		}

		public void setResale(int resale) {
			this.resale = resale;
		}

		public boolean isBuild() {
			return build;
		}

		public void setBuild(boolean build) {
			this.build = build;
		}

		
}
