# Senior Software Testing Project:
Our goal with this project was to test the functionality of the Luma Apparel website. This website is a website made with the purpose of automation testing in mind and worked as a perfect website for this project to allow us to check a number of different functionalities that many retail websites contain.
We originally wanted to use the Target website; however, their website has protections put in place that block automation testing and didn’t allow us to test various functionality such as logging in to an account, adding items to a cart, or viewing and leaving a review for an item.

# Our Classes:
### Logging into an account: ###
An important part of any retail website is having an account that users can log into and retain various details personal to them. To test this functionality, we wrote our test to navigate to the website’s homepage, click on the ‘Sign In’ button, enter our email and password associated with our testing account, and then navigate to the profile page to ensure the account has successfully logged in. Our test case is considered “Passed” if the profile page is shown with our account information visible.
### Viewing product details: ###
Being able to view items on a retail site is one of the main functionalities, so in order to test this we wrote our test to first search for an item using the search bar on the main page, then check if the first item is visible and clickable, and lastly check if the price of the item is visible on the screen. This process ensures that the items show up as expected when a search is conducted and that the items are clickable for a user when they make a search.
### Reviewing an item: ###
Being able to compare items on a retail website is necessary to see differences between items and figure out which one a user would like more. To test this functionality, we wrote our test to first search for a “bag” item, and then we would click the “add to compare” option for the first 2 items in the search. Once the items were added to the comparison, we navigate to the comparison view for the items and determine if both items show up in the comparison by checking that the comparison list contained exactly 2 items.
### Adding an item to the shopping cart: ###
The last test in our suite was checking if an item can be added to a shopping cart. This is vital for users of retail websites because it enables them to check out and purchase items. To test this, we began by searching for an item and then selecting the first one. We then chose a size and color for the item and clicked “add to cart”. If the cart updated and reflected that 1 item was added to the cart, this test case passed.

# Workflow Diagram:
![alt text](https://github.com/patriciaandreica/TestingProject/blob/main/img/user_Diagram_2.png)
