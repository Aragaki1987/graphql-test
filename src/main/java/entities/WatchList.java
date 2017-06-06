package entities;

public class WatchList {
	
	int id;
	String name;
	String list;
	int owner_id;
	int company_id;
	
	public WatchList(){
	}
	
	public WatchList(int id, String n, String l, int owner, int company){
		this.id = id;
		this.name = n;
		this.list = l;
		this.owner_id = owner;
		this.company_id = company;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	
	
	
	

}
