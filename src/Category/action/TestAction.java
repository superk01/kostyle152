package Category.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Category.model.Product;

public class TestAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> product_list = new ArrayList<Product>();
		product_list.add(new Product("일일","이번","삼번","사번"));
		product_list.add(new Product("9일일","이번","삼번","사번"));
		product_list.add(new Product("0일일","이번","삼번","사번"));
		product_list.add(new Product("8일일","이번","삼번","사번"));
		request.setAttribute("product_list", product_list);
		RequestDispatcher re = request.getRequestDispatcher("CategorysearchResult/CategorysearchResult.jsp");
		re.forward(request, response);
	}

}
