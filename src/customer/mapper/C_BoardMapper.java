package customer.mapper;

import java.util.List;

import customer.model.Answer;
import customer.model.C_Board;
import customer.model.Search;

public interface C_BoardMapper {

	public List<C_Board> list(Search search);

	public int insertBoard(C_Board board);

	public Integer add();

	public C_Board detailBoard(int q_num);

	public int updateBoard(C_Board board);

	public int deleteBoard(int q_num);

	public String getC_Id(int c_num);

	public Integer addAs_Num();

	public int insertAnswer(Answer answer);

}
