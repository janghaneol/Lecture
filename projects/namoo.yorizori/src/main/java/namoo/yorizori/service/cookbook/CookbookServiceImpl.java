package namoo.yorizori.service.cookbook;

import java.sql.SQLException;
import java.util.List;

import namoo.yorizori.common.factory.JdbcDaoFactory;
import namoo.yorizori.common.web.YZRuntimeException;
import namoo.yorizori.dao.cookbook.CookbookDao;
import namoo.yorizori.dto.cookbook.Cookbook;
import namoo.yorizori.dto.cookbook.Recipe;

public class CookbookServiceImpl implements CookbookService{
	CookbookDao cookbookDao = JdbcDaoFactory.getInstance().getCookbookDao();
		
	
	@Override
	public void registerCookbook(Cookbook cookbook) {
		// TODO Auto-generated method stub
		try {
			cookbookDao.create(cookbook);
		} catch (SQLException e) {
			
		}
		
	}

	@Override
	public Cookbook findCookbookById(int bookid) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<Cookbook> findCookbookByAll() throws SQLException {
		// TODO Auto-generated method stub
		try {
			cookbookDao.findCookbookByAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cookbookDao.findCookbookByAll();
	}

	@Override
	public void registerRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Recipe findRecipeById(int recipeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> findRecipeByAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
