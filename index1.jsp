<html>
	<head>
		<link rel="stylesheet" type="text/css" href="CSS/style.css">
		<script type="text/javascript">
			function showItem()
			{
					
				var arg=document.getElementById("item");
				var k=arg.options[arg.selectedIndex].value;
				window.open('showitem.html?n='+k,'width=400','height=400');
				
			}
			
			function validateQuantity(inputField,helpText)
			{
				
       				if (inputField.value.length == 0 || inputField.isNaN()==true) 
				{
          				if (helpText != null)
            					helpText.innerHTML = "Please enter a value.";
						alert(helpText.innerHTML);
          				return false;
        			}
        			else 
				{
          				if (helpText != null)
            					helpText.innerHTML = "";
					
          				return true;
				}
        		}
      

			
		</script>
		<title>Shopping Cart</title>
	</head>
	<body>
			<p id="nametext">Welcome <% String name=(String)session.getAttribute("Name"); out.print (name); %></p>
			<p id="key"> Your Session Key : <% String id=(String)session.getId();id=id.substring(0,7); out.print(id); %> </p>
		<form id="shopform" name="shopform" method="post" action="CartServlet">
				<h1>Hop in Shop out!</h1>

		<br/><div id="lefty">
			Enna vaenum Ungalukku?
			
			<select id="item" name="item" >
				<optgroup label="T Shirts">
					<option value="adidas">Adidas T-Shirt</option>
					<option value="reebok">Reebok T-Shirt</option>
					<option value="nike">Nike T-Shirt</option>
				</optgroup>
				<optgroup label="Sarees">
					<option value="kanchipuram">Kanchipuram Silk Saree</option>
					<option value="ahimsa">Ahimsa Silk Saree</option>
					<option value="samudrika">Samudrika Pattu Saree</option>
				</optgroup>
				<optgroup label="Jeans">
					<option value="denim">Denim Jeans</option>
					<option value="levis">Levis Jeans</option>
					<option value="pepe">Pepe Jeans</option>
				</optgroup>
			</select>
		</div>
		<div id="lefty">
			Quantity
			<input type="text" name="quantity" id="quantity" size=2 onblur="validateQuantity(this,document.getElementById('add_help'))">
			<span id="add_help"></span>
		</div>	
		<br/>
		
		<div id="lefty"> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="look" value="Have a closer look!" onclick="showItem();" >
			&nbsp;&nbsp;&nbsp;
			<input type="submit" name="submit" id="submit" value="Add to cart!" onclick="validateQuantity(document.getElementById('quantity'),document.getElementById('add_helptext'))">
			<span id="add_helptext"></span>

		</div>
		
		</form>
		<form id="checkout" name="checkout" method="post" action="CalcServlet">
		<div id="lefty"> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" name="submit" id="submit" value="Check Out" >

		</div>
		</form>
			
	</body>
</html>
