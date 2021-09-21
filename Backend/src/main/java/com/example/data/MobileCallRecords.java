package com.example.data;

public class MobileCallRecords {

	private String timestamp;
	private String callerMSISDN;
	private Long callCellTowerId;
	private String receiverMSISDN;
	private Long receiverTowerId;

	public MobileCallRecords(String timestamp, String callerMSISDN, Long callCellTowerId, String receiverMSISDN,
			Long receiverTowerId) {
		super();
		this.timestamp = timestamp;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
	}

	public MobileCallRecords(String callerMSISDN, Long callCellTowerId, String receiverMSISDN, Long receiverTowerId) {
		super();
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
	}

	public MobileCallRecords() {
		super();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCallerMSISDN() {
		return callerMSISDN;
	}

	public void setCallerMSISDN(String callerMSISDN) {
		this.callerMSISDN = callerMSISDN;
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

}
