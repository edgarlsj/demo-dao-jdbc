package model.DaoFactory;

import db.DB;
import model.SellerDAO;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDAO createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());

    }
}