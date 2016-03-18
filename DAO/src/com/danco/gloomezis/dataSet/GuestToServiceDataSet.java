package com.danco.gloomezis.dataSet;

public class GuestToServiceDataSet {

	/** The guest to service id. */
	private int guestToServiceId;
	
	/** The guest id. */
	private int guestId;
	
	/** The service id. */
	private int serviceId;

	/**
	 * Instantiates a new guest to service dao.
	 *
	 * @param guestToServiceId the guest to service id
	 * @param guestId the guest id
	 * @param serviceId the service id
	 */
	public GuestToServiceDataSet(int guestToServiceId, int guestId, int serviceId) {
		super();
		this.guestToServiceId = guestToServiceId;
		this.guestId = guestId;
		this.serviceId = serviceId;
	}

	/**
	 * Instantiates a new guest to service dao.
	 *
	 * @param guestId the guest id
	 * @param serviceId the service id
	 */
	public GuestToServiceDataSet(int guestId, int serviceId) {
		super();
		this.guestToServiceId = -1;
		this.guestId = guestId;
		this.serviceId = serviceId;
	}

	/**
	 * Gets the guest to service id.
	 *
	 * @return the guest to service id
	 */
	public int getGuestToServiceId() {
		return guestToServiceId;
	}

	/**
	 * Gets the guest id.
	 *
	 * @return the guest id
	 */
	public int getGuestId() {
		return guestId;
	}

	/**
	 * Gets the service id.
	 *
	 * @return the service id
	 */
	public int getServiceId() {
		return serviceId;
	}
}
