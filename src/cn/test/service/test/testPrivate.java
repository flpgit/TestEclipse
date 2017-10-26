package cn.test.service.test;
class Person{
	private String name;
	private Integer age;
	public Person(String name,Integer age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void print0(){
		System.out.println("***public*****");
	}
	private  void print1(){
		System.out.println("******private*******");
	}
}
public class testPrivate {
	public static void main(String[] args) {
		Person per = new Person("张三",30);
		per.print0();
//		per.print1();   //会提示Person类中的该方法是不可见的
	}

}
