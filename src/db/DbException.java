package db;

public class DbException extends RuntimeException{

	public String msg;
	
	public DbException(String msg) {
		this.msg = msg;
	}
	private static final long serialVersionUID = 1L;

}
