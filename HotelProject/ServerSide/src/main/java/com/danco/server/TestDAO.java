package com.danco.server;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.danco.dao.api.IGuestDAO;
import com.danco.dao.api.IHotelRoomDAO;
import com.danco.dao.api.IOrdersDAO;
import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Orders;

public class TestDAO {


public static void main(String[] args) {
	 final String LOGER_PROPERTY_FILE_PATH = "log4j.properties";
	 PropertyConfigurator.configure(LOGER_PROPERTY_FILE_PATH);
	
		/*
	 SessionFactory sessionFactory = cfg.buildSessionFactory();
	 Session session = sessionFactory.openSession();
	 */
	 
	// SessionFactory sessionFactory=null;
	 SessionFactory sessions1=null;
		try {
			
			// sessions1=  new Configuration().configure().buildSessionFactory();
			 
			 Configuration configuration = new Configuration().configure();
	            ServiceRegistry serviceRegistry
	                = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	             System.out.println("Configuration load");
	            // builds a session factory from the service registry
	            sessions1 = configuration.buildSessionFactory(serviceRegistry); 
			
			/*
			 Configuration configuration = new Configuration().configure();
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	             System.out.println("Configuration load");
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	            System.out.println("Session factory create");
	            */
		} catch (Throwable e) {
			 System.out.println("Initial SessionFactory creation failed. :" + e);
			
	            throw new ExceptionInInitializerError(e);
		}		
		
	//Session session = sessionFactory.openSession();
	 Session session =sessions1.openSession();
	 
	 IGuestDAO guestDAO = (IGuestDAO) DependencyInjectionManager
	.getClassInstance(IGuestDAO.class);
	 
	 IHotelRoomDAO hotelRoomDAO = (IHotelRoomDAO)DependencyInjectionManager.getClassInstance(IHotelRoomDAO.class);
	 
	 IServiceDAO serviceDAO = (IServiceDAO)DependencyInjectionManager.getClassInstance(IServiceDAO.class);

	 IOrdersDAO ordersDAO = (IOrdersDAO)DependencyInjectionManager.getClassInstance(IOrdersDAO.class);

	try {
		session.beginTransaction();
		
		//GUEST TEST
		//Guest g = new Guest("Dika");
		//session.beginTransaction();
		//guestDAO.create(session, g);
		//g.setId(11);
		//session.getTransaction().commit();
		//guestDAO.update(session, g);
		//Guest f =guestDAO.getById(session, 11);
		//session.getTransaction().commit();
		
		
	//+	
	//List<Guest>allSortedGuests =guestDAO.getList(session, "name");
	//	for (Guest s : allSortedGuests) {
	//		System.out.println(s.getId()+ s.getName());
	//	}
		
	//+
	//int i=	guestDAO.getAllGuestNumber(session);
		
		//HOTELROOM TEST
		
		//HotelRoom hr = new HotelRoom("15",50,5,5);
		//hr.setId(9);
		//HotelRoom hr = hotelRoomDAO.getById(session, 9);
		//hotelRoomDAO.create(session, hr);
		//hotelRoomDAO.update(session, hr);
		//hotelRoomDAO.delete(session, hr);
		
		//+
        //	List<HotelRoom> allSortedRoom =hotelRoomDAO.getList(session, false, "id");
		//	for (HotelRoom s : allSortedRoom) {
		//		System.out.println(s.getId()+ s.getNumber());
		//	}
		
		
		//+
		//int i=hotelRoomDAO.getNumberFreeHotelRooms(session);
		//System.out.println(i);
		//+
	    // List<String> p=  hotelRoomDAO.getPriceHotelRoom(session);
	    // for (String b : p) {
	    //	System.out.println(b+" \n ");
	    // }
		
		//SERVICE TEST
		//Service sr = new Service("Kuka", 58);
		//sr.setOrder(ordersDAO.getById(session, 1));
		//sr.setId(8);
		// serviceDAO.update(session, sr);
		//serviceDAO.delete(session, sr);
		
		//+
		//List<Service> allSortedService =serviceDAO.getList(session, "name");
		//	for (Service s : allSortedService) {
		//		System.out.println(s.getId()+ s.getName());
		//	}
		
		//+
		//List<Service> service =serviceDAO.getGuestThemServices(session, 1);
		//for (Service b : service) {
		//   	System.out.println(b.getName()+" \n ");
		//    }
		
		//+
		//int summ=serviceDAO.getSumServiceForGuest(session, 1);
		//System.out.println(summ);
		
		//+
		//List<String> rez=serviceDAO.getPriceService(session);
		//for (String b : rez) {
		//    	System.out.println(b+" \n ");
		//}
	    //ORDER TEST
		
		//Orders order = new Orders(hotelRoomDAO.getById(session, 1),  new Date(), new Date());
		//order.setGuest(guestDAO.getById(session, 1));
		//order.setId(7);
		//order.setPaid(true);
		//ordersDAO.create(session, order);
		//ordersDAO.update(session, order);
		
		//+
		//List<Orders> allSortedOrders =ordersDAO.getList(session, "id");
		//			for (Orders s : allSortedOrders) {
		//				System.out.println(" "+s.getId()+s.getDateArrive());
		//			}
		
		
		//+
		//Orders order=ordersDAO.getOrdersForIdGuest(session,1);
		//System.out.println(order.getGuest().getName());
		
		// - дописать вывод =)
		int r=ordersDAO.getPriceOrderForGuest(session, 1);
		session.getTransaction().commit();
		
		System.out.println("Operation complite"+" result"+r);
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}finally{
		session.close();
	}
	
}
}
