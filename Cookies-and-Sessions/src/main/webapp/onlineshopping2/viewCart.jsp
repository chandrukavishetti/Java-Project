<%@ page import="java.util.*"%>

<h2>Your Cart</h2>

<%
List<String> cart = (List<String>) session.getAttribute("cart");

if (cart == null || cart.isEmpty()) {
%>
<h3>Cart is Empty</h3>
<%
} else {
int total = 0;
%>

<table border="1">
	<tr>
		<th>Product</th>
		<th>Price</th>
	</tr>

	<%
	for (String item : cart) {
		String[] parts = item.split("-");
		String name = parts[0];
		int price = Integer.parseInt(parts[1]);
		total += price;
	%>

	<tr>
		<td><%=name%></td>
		<td><%=price%></td>
	</tr>

	<%
	}
	%>

</table>

<h3>
	Total Items:
	<%=cart.size()%></h3>
<h3>
	Total Amount:
	<%=total%></h3>

<%
}
%>

<br>
<a href="productlist.html">Add More Products</a>
<br>
<br>
<a href="../clear-cart">Clear Cart</a>