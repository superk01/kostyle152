package stats.mapper;

import java.util.List;

import stats.model.HitCount;
import stats.model.ShoppingMall;

public interface StatsMapper {
	public int insertHitCount(HitCount HitCount);
	public List<HitCount> listHitCount();
	public ShoppingMall getSNum(String s_shopurl);
}
