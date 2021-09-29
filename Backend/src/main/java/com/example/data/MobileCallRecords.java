package com.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MobileCallRecords {

	public MobileCallRecords(Long Id, String timestamp, String callerMSISDN, Long callCellTowerId,
			String receiverMSISDN, Long receiverTowerId) {
		super();
		this.callCellTowerId = Id;
		this.timestamp = timestamp;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
	}

	public MobileCallRecords(String timestamp, String callerMSISN, Long callCellTowerId, String receiverMSISDN,
			Long receiverTowerId) {
		super();
		this.timestamp = timestamp;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
	}

	public MobileCallRecords() {
		super();
	}

	@Column(name = "timestamp")
	private String timestamp;

	@Id
	@Column(name = "id")
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "caller_MSISDN", nullable = false)
	private PeopleMobile phoneNumber;

	@Column(name = "call_cell_tower_id")
	private Long callCellTowerId;

	@Column(name = "receiver_MSISDN")
	private String receiverMSISDN;

	@Column(name = "receiver_tower_id")
	private Long receiverTowerId;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getCallCellTowerId() {
		return callCellTowerId;
	}

	public void setCallCellTowerId(Long callCellTowerId) {
		this.callCellTowerId = callCellTowerId;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	public Long getReceiverTowerId() {
		return receiverTowerId;
	}

	public void setReceiverTowerId(Long receiverTowerId) {
		this.receiverTowerId = receiverTowerId;
	}

	public PeopleMobile getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PeopleMobile phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
