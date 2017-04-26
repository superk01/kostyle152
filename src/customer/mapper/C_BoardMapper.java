package customer.mapper;

import java.util.List;

import customer.model.C_Board;
import customer.model.Search;

public interface C_BoardMapper {

	List<C_Board> list(Search search);

	int insertBoard(C_Board board);

	int add(C_Board board);

	C_Board detailBoard(int q_num);

	int updateBoard(C_Board board);

	int deleteBoard(int q_num);

}
