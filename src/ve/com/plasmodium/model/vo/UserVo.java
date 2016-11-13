package ve.com.plasmodium.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private short idUser;
	private Integer user;
	private String doc;
	private String name;
	private String lastname;
	private String email;
	private String jobtitle;
	private short level;
	private String login;
	private byte[] pwd;
	private Date validTo;
	private String password;
	private boolean active;
	private long version;

	private List<Company> companys = new ArrayList<Company>();


	public UserVo() {
	}

	public UserVo(Integer user) {
		this.user = user;
	}

	// Constructor esta incompleto
	public UserVo(Integer user, String doc, String name, String lastname, String email, String jobtitle, short level, String login, byte[] pwd,
			/*String password,*/ boolean active, long version) {
		this.user = user;
		this.doc = doc;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.jobtitle = jobtitle;
		this.level = level;
		this.login = login;
		this.pwd = pwd;
		this.active = active;
		this.version = version;
	}

	public UserVo(Integer user, String doc, String name, String lastname, String email, String jobtitle, short level, String login) {
		this.user = user;
		this.doc = doc;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.jobtitle = jobtitle;
		this.level = level;
		this.login = login;
	}


	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public byte[] getPwd() {
		return pwd;
	}

	public void setPwd(byte[] pwd) {
		this.pwd = pwd;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (user != null ? user.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// not set
		if (!(object instanceof UserVo)) {
			return false;
		}
		UserVo other = (UserVo) object;
		if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ve.com.novared.model.to.User[user=" + user + "]";
	}

	public short getIdUser() {
		return idUser;
	}

	public void setIdUser(short idUser) {
		this.idUser = idUser;
	}

	public List<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}


}
