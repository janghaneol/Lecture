package namoo.common.factory;

import namoo.user.dao.UserDao;

/**
 * DaoFactory에 대한 규약을 선언하는 인터페이스
 * @author Administrator
 *
 */
public interface DaoFactory {
	
	public UserDao getUserDao();
//	public BoardDao createBoardDao();	-> 향후 다른 DAO가 생성됐을때 규약을 선언해준다.
//	public XXXDao createXXXDao();
}
