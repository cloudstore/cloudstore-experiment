package co.codewizards.cloudstore.local.persistence;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

	private static final AtomicLong id = new AtomicLong(0);
	
	public static long next(){
		return id.incrementAndGet();
	}
}
