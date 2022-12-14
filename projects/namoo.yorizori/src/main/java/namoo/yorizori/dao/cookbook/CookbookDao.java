package namoo.yorizori.dao.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.common.web.Params;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;
import namoo.yorizori.dto.user.User;

/**
 * 영속적 데이터 처리를 위한 다양한 기술(JDBC, JPA, iBatis, Hibernate 등)들을 
 * 일관된 방법(메소드 호출)으로 접근할 수 있도록 규약 메소드 선언
 *  * @author 김기정
 */
public interface CookbookDao{
	/* Cookbook 요리 등록*/
	public void create(Cookbook cookbook) throws SQLException;
	
	public Cookbook findCookbookById(int bookid);
	
	public List<Cookbook> findCookbookByAll() throws SQLException;
	
	public void registerRecipe(Recipe recipe);
	
	public Recipe findRecipeById(int recipeid);
	
	public List<Recipe> findRecipeByAll();
}








