package austin.pattern;

import java.util.LinkedList;

public class ProducerConsumer {

	ProducerConsumer start = new ProducerConsumer();
	
	public static void main(String args[]){
		ShowProperties p = new ShowProperties();
		System.out.println(p);
		
	}
	
}


class ShowProperties{
	public String a;
	public String b;
	
	public void run(){
		
	}
	
}

class Store{
	
	LinkedList<Integer> productList = new LinkedList<Integer>();
	
	synchronized void add(Integer product){
		while(productList.size()>2){
			try{
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		productList.add(product);
		notifyAll();
	}
	
	synchronized Integer get(){
		while(productList.size() <= 0){
			try{
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Integer product = productList.removeFirst();
		notifyAll();
		return product;
	}
	
	/**
	 * toString
	 */
	public String toString(){
		String ans = "現有產品:";
		for(Integer product:productList){
			ans += product+",";
		}
		return ans;
	}
}

class Producer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}