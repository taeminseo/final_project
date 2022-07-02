package com.spring.project.food.category;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.food.shop.ShopDTO;
import com.spring.project.food.shop.menu.MenuDTO;

@Service
public class CateService implements ICateService{

	@Autowired(required = false) ICateDAO cateDao;
	@Autowired HttpSession session;
	
	@Override
	public ArrayList<ShopDTO> list(String category_num) {
		ArrayList<ShopDTO> list = cateDao.list(category_num);
		return list;
	}
	@Override
	public ArrayList<ShopDTO> slist(String category_num) {
		ArrayList<ShopDTO> sList = cateDao.sList(category_num);
		
		if(sList == null)	
			return null; 
		
		return sList;
	}

	@Override
	public ArrayList<MenuDTO> selectShop(String shop_id) {
		ArrayList<MenuDTO> mList = cateDao.mList(shop_id);
		return mList;

	}

	@Override
	public ArrayList<MenuDTO> selectMenu(String menu_name, String shop_id) {
		
		ArrayList<MenuDTO> oList = cateDao.oList(menu_name,shop_id);
		return oList;
	}
	@Override
	public ArrayList<CategoryDTO> selectCate(String shop_id) {
		ArrayList<CategoryDTO> selectCate = cateDao.menuCate(shop_id);
		return selectCate;
	}
	@Override
	public ArrayList<ShopCateDTO> shopCateList() {
		ArrayList<ShopCateDTO> shopCateList =cateDao.shopCate();
		return shopCateList;
	}

	
	

}
