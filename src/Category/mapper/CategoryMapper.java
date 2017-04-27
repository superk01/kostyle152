package Category.mapper;

import java.util.List;

import Category.model.Adshoppingmall;
import Category.model.Categorysmall;

public interface CategoryMapper {

	List<Categorysmall> categorysmallSelect(String midnum);
	List<String> categorymidSelect(String keyword);
	List<Adshoppingmall> getADShoppingmall();
	List<String> testgetADShoppingmall();
	

}
