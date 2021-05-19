# Succulent-Shop
- This project is an educational project for Trendyol Android Bootcamp 2021. It aims to login and signup with validations, to list succulent products and to show product details.
- Review the project design: [Figma Link](https://www.figma.com/file/aKFn9Czmk2ms2hqp4sctcw/Succulent-Shop?node-id=0%3A1)
<br/>
<h3>Assignment01: Create Signup Screen UI</h3>
    
- Created the UI of a signup screen in order for the users to create accounts before using the app.<br/>       
- The user input validated on the client-side and also will be validated on the server-side.<br/>
- The errors yielded from the client-side were showned by TextInputLayout built-in error mechanism.<br/>
- Designed the screen using TextInputLayouts and MaterialButtons as shown in the image.<br/>
- Added client-side validation to the fields and show related errors on the fields when user clicks SIGN UP button. (According to validation table)<br/>
- Clicking ALREADY HAVE AN ACCOUNT? button navigated user to Login Screen.<br/>
- Clicking CREATE AN ACCOUNT button on Login Screen navigated user to Signup Screen.<br/>
<br/>
<h3>Assignment02: Navigation Component and RecyclerView</h3>
     
- Created SignupFragment and moved logic from SignupActivity into there, deleting SignupActivity.<br/>  
- Added SignupFragment to the nav_graph.xml adding necessary actions.<br/>
- Added a function fun relatedProducts(productId: Int): List<Product> into ProductStore which returns arbitrary (random) list of related products.<br/>
- Added the Related Products section into ProductDetailFragment which gets data from ProductStore and displays it in a horizontal RecyclerView.<br/>
- Added a click listener to the related products which would navigate user to ProductDetailFragment for the clicked product.<br/>
- Extra: Created Related Products using Recyclerview multi view types


