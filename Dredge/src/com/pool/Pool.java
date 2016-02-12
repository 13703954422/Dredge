package com.pool;


import com.model.Href;



public class Pool {
	
	/**队列长度*/
	private final int MaxSize = 100;
	
	/**href池*/
	private Href[] hrefs ;
	
	/**队头*/
	private int front;
	
	/**队尾*/
	private int rear;
	
	/**元素的个数*/
	private int nItems;
	
	private static Pool pool = null ;
	
	
	private Pool() {
		hrefs = new Href[MaxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	/**单例模式*/
	public static Pool getInstance() {
		if(pool == null) {
			pool = new Pool();
		}
		return pool;
	}
	
	/**进队*/
	public void queue(Href href) {
		if(rear == MaxSize - 1)
			rear = -1;
		hrefs[++rear] = href;
		nItems++;
	}
	
	/**出队*/
	public Href dequeue() {
		Href temp = hrefs[front++];
		if(front == MaxSize)
			front = 0;
		nItems--;
		return temp;
	}
	
	/**是否满*/
	public boolean isFull() {
		return nItems == MaxSize ? true : false;
	}
	
	/**判断是否为空*/
	public boolean isEmpty() {
		return nItems == 0 ? true : false;
	}
	
	/**返回队列中元素个数*/
	public int size() {
		return this.nItems;
	}
	

}
