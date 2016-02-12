package com.consumer;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.pool.Pool;
import com.util.FileIO;

public class Consumer implements Runnable {
	
	private BlockingQueue bq = new ArrayBlockingQueue(10);
	
	private int i = 0;
	

	@Override
	public void run() {
		while(true) {
			if(Pool.getInstance().isEmpty()) {
				synchronized (this) {
					try {
						wait(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			} else {
				synchronized (this) {
					FileIO.appendFile(new File("G:\\topics.txt"), ++i + "   " + Pool.getInstance().dequeue().toString()+"\r\n");
					
				}
			}
			
	}
	
	
	}
	

}
