package namoo.yorizori.service.cookbook;

import java.sql.SQLException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Param;

import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;

/**
 * 요리책 관리 서비스
 * @author 김기정
 *
 */
public interface CookbookService {
	public void registerCookbook(Cookbook cookbook) throws SQLException;
	public Cookbook findCookbookById(int bookid);
	public List<Cookbook> findCookbookByAll() throws SQLException;
	public void registerRecipe(Recipe recipe);
	public Recipe findRecipeById(int recipeid);
	public List<Recipe> findRecipeByAll();
	
}
