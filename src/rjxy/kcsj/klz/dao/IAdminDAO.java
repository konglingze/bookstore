package rjxy.kcsj.klz.dao;

import rjxy.kcsj.klz.vo.Admin;

public interface IAdminDAO {
	public boolean findLogin(Admin admin)throws Exception;
}
