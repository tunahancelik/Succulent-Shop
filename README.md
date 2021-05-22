<h1 align="center"> Succulent Shop </h1> <br>

<p align="center">
    <img alt="" title="" src="https://i.hizliresim.com/4bv1ozz.png" width="124">
  </a>
</p>


<p align="center">
Succulent Shop is a project developed by Trendyol Mobile Bootcamp participants during bootcamp.
</p>


## Table of Contents
- [Descriptions](#Descriptions)
- [Screenshots](#Screenshots)
- [Tech](#Tech)
- [Assignments](#Assignment)
- [Feedback](#feedback)

## Descriptions
This archive contains the first assignment of the project. 

Assignment includes sign up user interface design and client-side validation of e-mail, username and password entries.
There are [conditions](https://github.com/safaorhan/succulent-shop/issues/1) that the user must comply with when registering.

Click [here](https://www.figma.com/file/aKFn9Czmk2ms2hqp4sctcw/Succulent-Shop?node-id=0%3A1) to the figma design of the project.

## Screenshots
<table>
  <tr>
    <td>Login Screen</td>
     <td>Sign Up Screen</td>
     <td>Product List</td>
     <td>Product Product Detail Screen</td>
  </tr>
  <tr>
    <td><img src="https://i.hizliresim.com/jhz2cs3.png" width=270 height=450></td>
    <td><img src="https://i.hizliresim.com/1vfxcv5.png" width=270 height=450></td>
    <td><img src="https://i.hizliresim.com/pdghu34.png" width=270 height=450></td>
    <td><img src="https://i.hizliresim.com/bnx586f.png" width=270 height=450></td>
  </tr>
 </table>

## Tech
* **Kotlin**
* **Retrofit**
* **Gson**
* **Glide**

## Assignments

## Assignment: Create Signup Screen UI #1
* *Design the screen using TextInputLayouts and MaterialButtons as shown in the image.*
* *Add client-side validation to the fields and show related errors on the fields when user clicks SIGN UP button. (See validation table)*
* *Clicking ALREADY HAVE AN ACCOUNT? button should navigate user to Login Screen.*
* *Clicking CREATE AN ACCOUNT button on Login Screen should navigate user to Signup Screen.*

## Assignment: Navigation Component and RecyclerView #2
* *Create SignupFragment and move logic from SignupActivity into there, deleting SignupActivity.*
* *Add SignupFragment to the nav_graph.xml adding necessary actions.*
* *Add a function fun relatedProducts(productId: Int): List<Product> into ProductStore which returns arbitrary (random or any logic) list of related products.*
* *Add the Related Products section into ProductDetailFragment which gets data from ProductStore and displays it in a horizontal RecyclerView.*
* *Add a click listener to the related products which would navigate user to ProductDetailFragment for the clicked product.*

## Assignment: Integrate Signup and Related Products API #3
### *Signup API*
* *Send request to /auth/local/register when user tries to sign up and all client side validations pass.*
* *Handle the response and..*
  * *if it's successful save the jwt and navigate to product list screen, popping all the backstack.*
  * *for errors with 4XX status code display the returned message in a Snackbar.*
  * *for other status codes display Unexpected error occurred in a Snackbar.*
* *Handle other connectivity problems (eg. device is not connected to internet) and show this message in a Snackbar: Please check your connection and try again.*
### *Related Products*
* *Make api request to /related-products/:id where :id is the id of the product displayed.*
* *Handle 401 status code and navigate to login screen in that case.*
* *When the returned list is empty (there is no related products to the product queried) then hide the related products title TextView and the RecyclerView.*
* *When the returned list is non-empty fill the RecyclerView with the given list.*
### *Circular Progress Indicator*
* *In Product List screen show a circular progress indicator until the list is loaded.*
* *In Product Detail screen show a circular progress indicator until the product detail and the related products are both loaded.*
### *Logout Action*
* *Add a menu which is visible only in Product List screen and show a logout action in the overflow menu.*
* *When user selects this menu item, delete the token and navigate to login popping all the back stack.*
### *Skip login flow when user is logged in*
* *When user successfully logs in or signs up, do not show Signup or Login screens to the user anymore until the user logs out.*

## Feedback

Feel free to send us feedback on <a href="https://twitter.com/tunahanbeyy" target="_blank">![Twitter Badge](https://img.shields.io/badge/-Twitter-1ca0f1?style=flat&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/tunahanbeeyy)</a> or <a href="https://t.me/tunahanbeeyy" target="_blank">![Telegram Badge](https://img.shields.io/badge/-Telegram-1ca0f1?style=flat&labelColor=1ca0f1&logo=telegram&logoColor=white&link=https://t.me/lincolnbrito)</a> or <a href="mailto:celiktnhn@gmail.com" target="_blank">![Gmail Badge](https://img.shields.io/badge/-Gmail-c14438?style=flat&logo=Gmail&logoColor=white&link=mailto:celiktnhn@gmail.com)</a> . Feature requests are always welcome. If you wish to contribute, please contact me!


## :link: Follow me
<a href="https://github.com/tunahancelik" target="_blank">![Github Badge](https://img.shields.io/badge/-Github-000?style=flat&logo=Github&logoColor=white&link=https://github.com/tunahancelik)</a>
<a href="https://www.linkedin.com/in/tunahan-celik/" target="_blank">![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/tunahan-celik)</a>
<a href="https://twitter.com/tunahanbeyy" target="_blank">![Twitter Badge](https://img.shields.io/badge/-Twitter-1ca0f1?style=flat&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/tunahanbeeyy)</a>
<a href="https://instagram.com/mr.tunahancelik" target="_blank">![Instagram Badge](https://img.shields.io/badge/-Instagram-E4405F?style=flat&logo=instagram&logoColor=white&link=https://instagram.com/tunahanbeeyy)</a>

✨ [My Personal Web Page](https://tunahancelik.github.io)
