package com.example.getdiamond.models;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class ExchangeModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	    private Date createDate;
	    private boolean accepted;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_asker", nullable = false)
	    //@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private UserModel asker;
	    
	    private  int opalAsker;
	    private  int emeraldAsker;
	    private  int diamondAsker;
	    private  int rubyAsker;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_receiver", nullable = true)
	    //@JsonIgnore
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private UserModel receiver;
	    
	    private  int opalReceiver;
	    private  int emeraldReceiver;
	    private  int diamondReceiver;
	    private  int rubyReceiver;
	    
		public ExchangeModel() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public boolean isAccepted() {
			return accepted;
		}

		public void setAccepted(boolean accepted) {
			this.accepted = accepted;
		}

		public UserModel getAsker() {
			return asker;
		}

		public void setAsker(UserModel asker) {
			this.asker = asker;
		}

		public int getOpalAsker() {
			return opalAsker;
		}

		public void setOpalAsker(int opalAsker) {
			this.opalAsker = opalAsker;
		}

		public int getEmeraldAsker() {
			return emeraldAsker;
		}

		public void setEmeraldAsker(int emeraldAsker) {
			this.emeraldAsker = emeraldAsker;
		}

		public int getDiamondAsker() {
			return diamondAsker;
		}

		public void setDiamondAsker(int diamondAsker) {
			this.diamondAsker = diamondAsker;
		}

		public int getRubyAsker() {
			return rubyAsker;
		}

		public void setRubyAsker(int rubyAsker) {
			this.rubyAsker = rubyAsker;
		}

		public UserModel getReceiver() {
			return receiver;
		}

		public void setReceiver(UserModel receiver) {
			this.receiver = receiver;
		}

		public int getOpalReceiver() {
			return opalReceiver;
		}

		public void setOpalReceiver(int opalReceiver) {
			this.opalReceiver = opalReceiver;
		}

		public int getEmeraldReceiver() {
			return emeraldReceiver;
		}

		public void setEmeraldReceiver(int emeraldReceiver) {
			this.emeraldReceiver = emeraldReceiver;
		}

		public int getDiamondReceiver() {
			return diamondReceiver;
		}

		public void setDiamondReceiver(int diamondReceiver) {
			this.diamondReceiver = diamondReceiver;
		}

		public int getRubyReceiver() {
			return rubyReceiver;
		}

		public void setRubyReceiver(int rubyReceiver) {
			this.rubyReceiver = rubyReceiver;
		}
	    
	    
}
