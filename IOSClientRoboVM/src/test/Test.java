package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;

import co.codewizards.cloudstore.local.persistence.Directory;
import co.codewizards.cloudstore.local.persistence.RepoFile;
import test.PersistenceTest;


public class Test {
	
	// for testing purposes should be set to path specific to the environment
	private static final String STORAGE_DIRECTORY = "/Users/wilk/Test";

	public void create(){
		//testReadWriteListFiles();

		//dummyTestIfBouncyCastleIsImported();
		//test();
		new PersistenceTest().run();
	}
	
	private void dummyTestIfBouncyCastleIsImported(){
		// tries if the classes from bcpg and bcprov are detected,
		// if throws IllegalArgumentException then it is correct == classes are
		// loaded
		try {
			byte[] testKey = new byte[256];
			for (int i = 0; i < 256; i++) {
				testKey[i] = (byte) i;
			}
			byte[] testData = new byte[] { (byte) 10, (byte) 20, (byte) 30 };
			//new BCTest().encryptAES256(testData, testKey); // should
																	// throw
																	// exception
		} catch (Throwable ex) {
			if(ex.getClass() == IllegalArgumentException.class){
				System.out.println("Bouncy castle import works");
			}
		}
	}
	
	private void testReadWriteListFiles(){
		String path = new File(STORAGE_DIRECTORY).getAbsolutePath();
		System.out.println(path);
		File file = new File(STORAGE_DIRECTORY + "/test.txt");
		try {

			PrintWriter writer = new PrintWriter(file);
			writer.append("test");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			if("test".equals(scanner.next())){
				System.out.println("Reading from file works");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Files in directory /Users/wilk/Test : ");
		
		for(File testFile : new File("/Users/wilk/Test").listFiles()){
			System.out.println(testFile);
		}
	}
	
	private void testCreateDatabaseDN(){
		test();
		Properties properties = new Properties();
		properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", 
				"org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
		properties.setProperty("javax.jdo.option.ConnectionDriverName","SQLite.JDBCDriver");
		properties.setProperty("javax.jdo.option.ConnectionURL", 
				"jdbc:sqlite:/Users/wilk/Test/test5.db");
		properties.setProperty("datanucleus.schema.autoCreateAll",
				"true");

		try {
			Class.forName("org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("test");
			e1.printStackTrace();
		}
		PersistenceManagerFactory factory = JDOPersistenceManagerFactory.getPersistenceManagerFactory(
				properties);
		PersistenceManager manager = factory.getPersistenceManager();
		Transaction tx = manager.currentTransaction();
		
		try{
			tx.begin();
			Directory directory = new Directory();
			directory.setName("test");
			
			//SimpleEntity entity = new SimpleEntity();

			manager.makePersistent(directory);
			tx.commit();
			manager.close();
			manager = factory.getPersistenceManager();
			tx = manager.currentTransaction();
			tx.begin();
		//	entity = manager.getObjectById(SimpleEntity.class,entity.getId());
			//manager.deletePersistent(entity);
			tx.commit();
			
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			manager.close();
		}
		
		manager = factory.getPersistenceManager();
		tx = manager.currentTransaction();
		
		try{
			tx.begin();
			manager.getFetchPlan().setFetchSize(1);
//			Query query = manager.newQuery(SimpleEntity.class);
//			query.getFetchPlan().setFetchSize(1);
//			Collection collection = (Collection)query.execute();
//			
//			System.out.println(collection.size());
			tx.commit();
			
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
			manager.close();
		}
	}
	
	public void testCreateDatabaseJDBC(){
		Connection c = null;
		try {

			Class.forName("SQLite2.DelegateJDBCDriver");
			Enumeration<Driver> enumeration = DriverManager.getDrivers();
			Driver driver = null;
			while(enumeration.hasMoreElements()){
				driver = enumeration.nextElement();
			}
			c = driver.connect("jdbc:sqlite:/Users/wilk/Test/test2.db", new Properties());
			System.out.println("tutaj");
			//c = DriverManager
				//	.getConnection("jdbc:sqlite:/Users/wilk/Test/test2.db");
			System.out.println("Database opened successfully");
			Statement stmt = c.createStatement();

			System.out.println("Table created");

			ResultSet rs = stmt.executeQuery("CREATE TABLE repofile"
+"("
 +"   id bigint NOT NULL,"
  +"  lastmodified TIMESTAMP NOT NULL,"
  +" lastsyncfromrepositoryid VARCHAR(255) NULL,"
   +" localrevision bigint NOT NULL,"
  +"  \"name\" VARCHAR(255) NOT NULL,"
  +"  parent_id_oid bigint NULL,"
   +" changed TIMESTAMP NOT NULL,"
 +"   created TIMESTAMP NOT NULL,"
  +"  discriminator VARCHAR(255) NOT NULL,"
  +"  CONSTRAINT repofile_pk PRIMARY KEY (id)"
  + ")");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			rs.close();
			stmt.close();
			c.close();

			System.out.println("Records inserted");
			
			stmt.close();
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(c);
		}
	}
	
	private void test(){
		Connection c = null;
		try {

			Class.forName("SQLite2.DelegateJDBCDriver");
			c = DriverManager
					.getConnection("jdbc:sqlite:/Users/wilk/Test/test.db");
			System.out.println("Database opened successfully");
			Statement stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM SIMPLEENTITY;");
			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println("ID = " + id);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();

			System.out.println("Records inserted");
			
			stmt.close();
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(c);
		}
	}
	
	
}
