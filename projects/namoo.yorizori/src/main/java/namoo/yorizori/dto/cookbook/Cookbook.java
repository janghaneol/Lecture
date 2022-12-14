package namoo.yorizori.dto.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.common.factory.JdbcDaoFactory;
import namoo.yorizori.common.web.Params;
import namoo.yorizori.dao.user.UserDao;
import namoo.yorizori.dto.user.User;

/**
 * Cookbook DTO
 * @author 김기정
 *
 */
public class Cookbook{
	private int book_id;
	private String book_name;
	private String book_desc;
	private String author_id;
	
	
	public Cookbook() {
		
	}

	public Cookbook(int book_id, String book_name, String book_desc, String author_id) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_desc = book_desc;
		this.author_id = author_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_desc() {
		return book_desc;
	}

	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	
	
	
}
