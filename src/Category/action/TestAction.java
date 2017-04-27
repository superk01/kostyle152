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
		product_list.add(new Product("?ùº?ùº","?ù¥Î≤?","?ÇºÎ≤?","?Ç¨Î≤?"));
		product_list.add(new Product("9?ùº?ùº","?ù¥Î≤?","?ÇºÎ≤?","?Ç¨Î≤?"));
		product_list.add(new Product("0?ùº?ùº","?ù¥Î≤?","?ÇºÎ≤?","?Ç¨Î≤?"));
		product_list.add(new Product("8?ùº?ùº","?ù¥Î≤?","?ÇºÎ≤?","?Ç¨Î≤?"));
		request.setAttribute("product_list", product_list);
		RequestDispatcher re = request.getRequestDispatcher("CategorysearchResult/CategorysearchResult.jsp");
		re.forward(request, response);
	}

}
