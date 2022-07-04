package page.dto;

public class EmpDTO {
	// 변수선언	
	private int empno;
	private String ename;
	private String job;
	private int deptno;
	private String dname;
	private int sal;
	private int comm;
	private int tot;
	
	// 기본 생성자
	public EmpDTO() {
	}

	// 매개변수(파라미터) 있는 생성자
	public EmpDTO(int empno, String ename, String job, int deptno, String dname, int sal, int comm, int tot) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.deptno = deptno;
		this.dname = dname;
		this.sal = sal;
		this.comm = comm;
		this.tot = tot;
	}

	// getter, setter
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	// toString 오버라이드
	@Override
	public String toString() {
		return "empDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", deptno=" + deptno + ", dname="
				+ dname + ", sal=" + sal + ", comm=" + comm + ", tot=" + tot + "]";
	}
}
