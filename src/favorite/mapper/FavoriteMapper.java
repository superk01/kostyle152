package favorite.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import favorite.model.Favorite;

public interface FavoriteMapper {
	public List<Favorite> listFavorite(RowBounds row);
	public int countFavorite();
}
