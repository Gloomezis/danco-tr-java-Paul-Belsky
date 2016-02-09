package com.danco.ui;

import com.danco.command.ExitCommand;
import com.danco.command.ImportExportCSVCommand.GuestReadCsvFile;
import com.danco.command.ImportExportCSVCommand.GuestWriteCsvFile;
import com.danco.command.ImportExportCSVCommand.HotelRoomReadCsvFile;
import com.danco.command.ImportExportCSVCommand.HotelRoomWriteCsvFile;
import com.danco.command.ImportExportCSVCommand.ServiceReadCsvFile;
import com.danco.command.ImportExportCSVCommand.ServiceWriteCsvFile;
import com.danco.command.guestCommand.AddGuest;
import com.danco.command.guestCommand.AddServiceToGuest;
import com.danco.command.guestCommand.ShowAllGuestNumber;
import com.danco.command.guestCommand.ShowAllGuests;
import com.danco.command.guestCommand.ShowListOfService;
import com.danco.command.guestCommand.ShowSummToPaidGuest;
import com.danco.command.hotelRoomCommand.AddRooms;
import com.danco.command.hotelRoomCommand.ChangePriceOfHotelRoom;
import com.danco.command.hotelRoomCommand.ChangeStatus;
import com.danco.command.hotelRoomCommand.CloneHotelRoom;
import com.danco.command.hotelRoomCommand.DepartGuestFromHotelRoom;
import com.danco.command.hotelRoomCommand.SettleGuestToHotelRoom;
import com.danco.command.hotelRoomCommand.ShowAllFreeRooms;
import com.danco.command.hotelRoomCommand.ShowAllRooms;
import com.danco.command.hotelRoomCommand.ShowDetailOfHotelRoom;
import com.danco.command.hotelRoomCommand.ShowFreeRomsAfterDate;
import com.danco.command.hotelRoomCommand.ShowLast3GuestOfHotelRoom;
import com.danco.command.hotelRoomCommand.ShowNumberOfFreeHotelRooms;
import com.danco.command.reflObjInfo.showGuestReflectedObjectInfoDetailed;
import com.danco.command.reflObjInfo.showGuestReflectedObjectInfoShort;
import com.danco.command.reflObjInfo.showHotelRoomReflectedObjectInfoDetailed;
import com.danco.command.reflObjInfo.showHotelRoomReflectedObjectInfoShort;
import com.danco.command.reflObjInfo.showServiceReflectedObjectInfoDetailed;
import com.danco.command.reflObjInfo.showServiceReflectedObjectInfoShort;
import com.danco.command.serviceCommand.AddServices;
import com.danco.command.serviceCommand.ChangePriceOfService;
import com.danco.command.serviceCommand.ShowPriceServiceAndHotelRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class Builder.
 */
public class Builder {

	/** The root menu. */
	private Menu rootMenu = buildMenu();

	/** The Constant ROOT. */
	public static final String ROOT = "Root";

	/** The Constant GUEST_OPERATION. */
	public static final String GUEST_OPERATION = "Guest operation";

	/** The Constant HOTEL_ROOMS_OPERATION. */
	public static final String HOTEL_ROOMS_OPERATION = "Hotel rooms operation";

	/** The Constant SERVICES_OPERATION. */
	public static final String SERVICES_OPERATION = "Services operations";

	/** The Constant ADD. */
	public static final String ADD = "add";

	/** The Constant SHOW. */
	public static final String SHOW = "show";

	/** The Constant EDIT. */
	public static final String EDIT = "Edit";

	/** The Constant BACK. */
	public static final String BACK = "Back";

	/** The Constant EXIT. */
	public static final String EXIT = "Exit";

	/** The Constant READ_GUEST_FROM_FILE. */
	public static final String READ_GUEST_FROM_FILE = "Read guest from file";

	/** The Constant WRITE_GUEST_TO_FILE. */
	public static final String WRITE_GUEST_TO_FILE = "Write guest to file";

	/** The Constant ADD_GUEST. */
	public static final String ADD_GUEST = "Add guest";

	/** The Constant ADD_SERVICE_TO_GUEST. */
	public static final String ADD_SERVICE_TO_GUEST = "Add service to guest";

	/** The Constant SHOW_ALL_GUEST_NUMBER. */
	public static final String SHOW_ALL_GUEST_NUMBER = "Show all guest number";

	/** The Constant SHOW_ALL_GUESTS. */
	public static final String SHOW_ALL_GUESTS = "Show all guests";

	/** The Constant SHOW_LIST_SERVICES. */
	public static final String SHOW_LIST_SERVICES = "Show list services";

	/** The Constant SHOW_SUMM_TO_PAID_GUEST. */
	public static final String SHOW_SUMM_TO_PAID_GUEST = "Show summ to paid selected guest";

	/** The Constant DEPART_GUEST_FROM_HOTEL_ROOM. */
	public static final String DEPART_GUEST_FROM_HOTEL_ROOM = "Depart guest from hotel room";

	/** The Constant SETTLE_GUEST_TO_HOTEL_ROOM. */
	public static final String SETTLE_GUEST_TO_HOTEL_ROOM = "Settle guest to hotel room";

	/** The Constant ADD_ROOM. */
	public static final String ADD_ROOM = "Add room";

	/** The Constant CHANGE_PRICE_HOTEL_ROOM. */
	public static final String CHANGE_PRICE_HOTEL_ROOM = "Change price of hotel room";

	/** The Constant CHANGE_STATUS. */
	public static final String CHANGE_STATUS = "Change  status";

	/** The Constant SHOW_NUMBER_FREE_HOTEL_ROOMS. */
	public static final String SHOW_NUMBER_FREE_HOTEL_ROOMS = "Show number of free hotel rooms";

	/** The Constant SHOW_ALL_ROOMS. */
	public static final String SHOW_ALL_ROOMS = "Show all rooms";

	/** The Constant SHOW_ALL_FREE_ROOMS. */
	public static final String SHOW_ALL_FREE_ROOMS = "Show all free rooms";

	/** The Constant SHOW_ALL_FREE_ROOMS_AFTER_DATE. */
	public static final String SHOW_ALL_FREE_ROOMS_AFTER_DATE = "Show all free rooms after date";

	/** The Constant SHOW_DETAIL_SELECTED_ROOM. */
	public static final String SHOW_DETAIL_SELECTED_ROOM = "Show detail selected room";

	/** The Constant SHOW_LAST_3_GUEST_ROOM. */
	public static final String SHOW_LAST_3_GUEST_ROOM = "Show last 3 guest selected room";

	/** The Constant SHOW_PRICE_SERVICE_AND_HOTEL_ROOMS. */
	public static final String SHOW_PRICE_SERVICE_AND_HOTEL_ROOMS = "Show price of service and hotel rooms";

	/** The Constant ADD_SERVICE. */
	public static final String ADD_SERVICE = "Add service";

	/** The Constant CHANGE_PRICE_SERVICE. */
	public static final String CHANGE_PRICE_SERVICE = "Change price of service";

	/** The Constant CLONE. */
	public static final String CLONE = "Clone";

	/**
	 * Gets the root menu.
	 *
	 * @return the root menu
	 */
	public Menu getRootMenu() {
		return rootMenu;
	}

	/**
	 * Builds the menu.
	 *
	 * @return the menu
	 */
	public Menu buildMenu() {

		Menu rootMenu = new Menu(ROOT, null);
		Menu firstMenu = new Menu(GUEST_OPERATION, rootMenu);
		Menu secondMenu = new Menu(HOTEL_ROOMS_OPERATION, rootMenu);
		Menu threeMenu = new Menu(SERVICES_OPERATION, rootMenu);
		Menu firstAddMenu = new Menu(ADD, rootMenu);
		Menu firstShowMenu = new Menu(SHOW, rootMenu);
		Menu secondAddMenu = new Menu(ADD, rootMenu);
		Menu secondEditMenu = new Menu(EDIT, rootMenu);
		Menu secondShowMenu = new Menu(SHOW, rootMenu);
		Menu threeAddMenu = new Menu(ADD, rootMenu);
		Menu threeEditMenu = new Menu(EDIT, rootMenu);
		Menu threeShowMenu = new Menu(SHOW, rootMenu);
		Menu fourMenu = new Menu("Import/Export", rootMenu);

		/*
		 * guest operation menu
		 */
		firstMenu.getMenuItems().add(firstAddMenu);
		firstMenu.getMenuItems().add(firstShowMenu);
		firstMenu.getMenuItems().add(new MenuItems(BACK, null));

		firstAddMenu.getMenuItems().add(new MenuItems(ADD_GUEST, new AddGuest()));
		firstAddMenu.getMenuItems().add(new MenuItems(ADD_SERVICE_TO_GUEST, new AddServiceToGuest()));
		firstAddMenu.getMenuItems().add(new MenuItems(BACK, null));

		firstShowMenu.getMenuItems().add(new MenuItems(SHOW_ALL_GUEST_NUMBER, new ShowAllGuestNumber()));
		firstShowMenu.getMenuItems().add(new MenuItems(SHOW_ALL_GUESTS, new ShowAllGuests()));
		firstShowMenu.getMenuItems().add(new MenuItems(SHOW_LIST_SERVICES, new ShowListOfService()));
		firstShowMenu.getMenuItems().add(new MenuItems(SHOW_SUMM_TO_PAID_GUEST, new ShowSummToPaidGuest()));
		firstShowMenu.getMenuItems().add(new MenuItems("Show detailed info guest reflected", new showGuestReflectedObjectInfoDetailed()));
		firstShowMenu.getMenuItems().add(new MenuItems("Show short info guest reflected", new showGuestReflectedObjectInfoShort()));
		firstShowMenu.getMenuItems().add(new MenuItems(SHOW_SUMM_TO_PAID_GUEST, new ShowSummToPaidGuest()));
		firstShowMenu.getMenuItems().add(new MenuItems(BACK, null));

		/*
		 * Hotel rooms operation
		 */
		secondMenu.getMenuItems().add(secondAddMenu);
		secondMenu.getMenuItems().add(secondEditMenu);
		secondMenu.getMenuItems().add(secondShowMenu);
		secondMenu.getMenuItems().add(new MenuItems(DEPART_GUEST_FROM_HOTEL_ROOM, new DepartGuestFromHotelRoom()));
		secondMenu.getMenuItems().add(new MenuItems(SETTLE_GUEST_TO_HOTEL_ROOM, new SettleGuestToHotelRoom()));
		secondMenu.getMenuItems().add(new MenuItems(BACK, null));

		secondAddMenu.getMenuItems().add(new MenuItems(ADD_ROOM, new AddRooms()));
		secondAddMenu.getMenuItems().add(new MenuItems(CLONE, new CloneHotelRoom()));
		secondAddMenu.getMenuItems().add(new MenuItems(BACK, null));

		secondEditMenu.getMenuItems().add(new MenuItems(CHANGE_PRICE_HOTEL_ROOM, new ChangePriceOfHotelRoom()));
		secondEditMenu.getMenuItems().add(new MenuItems(CHANGE_STATUS, new ChangeStatus()));
		secondEditMenu.getMenuItems().add(new MenuItems(BACK, null));

		secondShowMenu.getMenuItems()
				.add(new MenuItems(SHOW_NUMBER_FREE_HOTEL_ROOMS, new ShowNumberOfFreeHotelRooms()));
		secondShowMenu.getMenuItems().add(new MenuItems(SHOW_ALL_ROOMS, new ShowAllRooms()));
		secondShowMenu.getMenuItems().add(new MenuItems(SHOW_ALL_FREE_ROOMS, new ShowAllFreeRooms()));
		secondShowMenu.getMenuItems().add(new MenuItems(SHOW_ALL_FREE_ROOMS_AFTER_DATE, new ShowFreeRomsAfterDate()));
		secondShowMenu.getMenuItems().add(new MenuItems(SHOW_DETAIL_SELECTED_ROOM, new ShowDetailOfHotelRoom()));
		secondShowMenu.getMenuItems().add(new MenuItems(SHOW_LAST_3_GUEST_ROOM, new ShowLast3GuestOfHotelRoom()));
		secondShowMenu.getMenuItems()
				.add(new MenuItems(SHOW_PRICE_SERVICE_AND_HOTEL_ROOMS, new ShowPriceServiceAndHotelRoom()));
		secondShowMenu.getMenuItems().add(new MenuItems("Show detailed info hotel room reflected", new showHotelRoomReflectedObjectInfoDetailed()));
		secondShowMenu.getMenuItems().add(new MenuItems("Show short info hotel room reflected", new showHotelRoomReflectedObjectInfoShort()));
		secondShowMenu.getMenuItems().add(new MenuItems(BACK, null));

		/*
		 * Services operation
		 */
		threeMenu.getMenuItems().add(threeAddMenu);
		threeMenu.getMenuItems().add(threeEditMenu);
		threeMenu.getMenuItems().add(threeShowMenu);
		threeMenu.getMenuItems().add(new MenuItems(BACK, null));

		threeAddMenu.getMenuItems().add(new MenuItems(ADD_SERVICE, new AddServices()));
		threeAddMenu.getMenuItems().add(new MenuItems(BACK, null));

		threeEditMenu.getMenuItems().add(new MenuItems(CHANGE_PRICE_SERVICE, new ChangePriceOfService()));
		threeEditMenu.getMenuItems().add(new MenuItems(BACK, null));

		threeShowMenu.getMenuItems()
				.add(new MenuItems(SHOW_PRICE_SERVICE_AND_HOTEL_ROOMS, new ShowPriceServiceAndHotelRoom()));
		threeShowMenu.getMenuItems().add(new MenuItems("Show detailed info service room reflected", new showServiceReflectedObjectInfoDetailed()));
		threeShowMenu.getMenuItems().add(new MenuItems("Show short info hotel service reflected", new showServiceReflectedObjectInfoShort()));
		
		threeShowMenu.getMenuItems().add(new MenuItems(BACK, null));

		/*
		 * Import/Export menu
		 */

		fourMenu.getMenuItems().add(new MenuItems("read guest from file", new GuestReadCsvFile()));
		fourMenu.getMenuItems().add(new MenuItems("write guest to file", new GuestWriteCsvFile()));
		fourMenu.getMenuItems().add(new MenuItems("read hotel room from file", new HotelRoomReadCsvFile()));
		fourMenu.getMenuItems().add(new MenuItems("write hotel room to file", new HotelRoomWriteCsvFile()));
		fourMenu.getMenuItems().add(new MenuItems("read service from file", new ServiceReadCsvFile()));
		fourMenu.getMenuItems().add(new MenuItems("write service to file", new ServiceWriteCsvFile()));
		fourMenu.getMenuItems().add(new MenuItems(BACK, null));

		/*
		 * Root menu
		 */
		rootMenu.getMenuItems().add(firstMenu);
		rootMenu.getMenuItems().add(secondMenu);
		rootMenu.getMenuItems().add(threeMenu);
		rootMenu.getMenuItems().add(fourMenu);
		rootMenu.getMenuItems().add(new MenuItems(EXIT, new ExitCommand()));

		return rootMenu;

	}
}
