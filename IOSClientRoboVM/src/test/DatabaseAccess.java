package test;

import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;

public class DatabaseAccess {

	private static final PersistenceManagerFactory factory;
	
	static{
		Properties properties = new Properties();
		properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", 
				"org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
		properties.setProperty("javax.jdo.option.ConnectionDriverName","SQLite.JDBCDriver");
		properties.setProperty("javax.jdo.option.ConnectionURL", 
				"jdbc:sqlite:/Users/wilk/Test/test.db");
		properties.setProperty("datanucleus.schema.autoCreateAll",
				"true");

		try {
			Class.forName("org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("test");
			e1.printStackTrace();
		}
		factory = JDOPersistenceManagerFactory.getPersistenceManagerFactory(
				properties);
	}
	
	private DatabaseAccess(){
	}
	
	public PersistenceManager manager(){
		return factory.getPersistenceManager();
	}
	
	public void runInTransactionContext(Action action){
		PersistenceManager manager = manager();
		Transaction transaction = manager.currentTransaction();
		try{
			transaction.begin();
			action.run();
			transaction.commit();
		} finally{
			if(transaction.isActive()){
				transaction.rollback();
			}
			manager.close();
		}
	}
	
	public interface Action{
		void run();
	}
}
