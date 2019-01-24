package entities;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrdersQueries 
{
	public static String addNewOrder(BookOrder bookOrder)
	{
		if (bookOrder == null)
			return null;
		String currentDateTimeString = getcurrentDateTimesString();
		
		String queryMsg = "INSERT INTO obl_db.orders (subscriberID, orderDate, bookCatalogNumber) "
						+ "VALUES ('" + bookOrder.getSubscriberId() + "', '" + currentDateTimeString + "', '" 
						+ bookOrder.getBookCatalogNumber() + "');";
		return queryMsg;
	}
	
	
	public static String getBookCurrentOrders(Book book)
	{
		if (book == null)
			return null;
		String queryMsg = "SELECT id, subscriberID, orderDate, status, bookArriveDate, bookCatalogNumber " 
						+ "FROM obl_db.orders " 
						+ "WHERE bookCatalogNumber = '" + book.getCatalogNumber() + "';";
		return queryMsg;
	}
	
	public static String getcurrentDateTimesString()
	{
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = format.format(calendar.getTime());
		return string;
	}
	
	public static String searchOrdersFromSubscriberID(String subscriberID)
	{
		if (subscriberID == null)
			return null;
		String queryMsg = "SELECT name, orderDate, status "  
				+" FROM obl_db.orders INNER JOIN obl_db.books ON orders.bookCatalogNumber = books.catalogNumber"
				+" WHERE orders.subscriberID ='"+ subscriberID +"';";
		return queryMsg;
	}
	
	public static ArrayList<ActivityLog> CreateOrdersListFromRS(ResultSet rs)
	{
		ArrayList<ActivityLog> logs = new ArrayList<ActivityLog>();
		try
		{
			while (rs.next())
			{
				ActivityLog temp = new ActivityLog("Order",rs.getString(1),rs.getString(2),rs.getString(3));
				logs.add(temp);
				
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return logs;
	}
}
