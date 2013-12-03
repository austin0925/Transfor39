package austin.pattern;

import java.util.Date;
import java.util.LinkedList;

public class GuardedSuspension {

	public static void main(String[] args){
		RequestQueue queue = new RequestQueue();
		(new Thread(new Server(queue))).start();
		(new Thread(new Service(queue))).start();
	}
}

interface Request{
	void execute();
}

/**
 * client sector
 * @author game
 *
 */
class RequestQueue{
	private LinkedList<Request> requests;
	
	public RequestQueue(){
		requests = new LinkedList<Request>();
	}
	
	int getSize(){
		return requests.size();
	}
	
	synchronized Request get(){
		while(requests.size() == 0){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
//		System.out.println("[remove]request size ="+requests.size());
		return requests.removeFirst();
	}
	
	synchronized void put(Request request){
//		System.out.println("[add]request size ="+requests.size());
		requests.addLast(request);
		notifyAll();
	}
	
}


/**
 * Service section 
 * @author game
 *
 */
class Server implements Runnable{

	private RequestQueue queue;
	
	Server(RequestQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true){
			Request request = new Request(){
				public void execute(){
					System.out.println("execute request...XD "+new Date(System.currentTimeMillis()));
					System.out.println("queue.size="+queue.getSize());
				}
			};
			queue.put(request);
			//暫停隨機時間
			try{
				Thread.sleep((int) Math.random() * 3000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

/**
 * Service sector
 * @author game
 *
 */
class Service implements Runnable{

	private RequestQueue queue;
	Service(RequestQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true){
			queue.get().execute();
			System.out.println("add request...XD "+new Date(System.currentTimeMillis()));
			System.out.println("queue.size="+queue.getSize());
			//隨機暫停
			try{
				Thread.sleep((int) (Math.random() * 3000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
}
