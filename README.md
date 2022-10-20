# Write an automated test based on the test scenario below:
| Step             	| Test Data                                                                	| Expected Result                    	|   	|   	|
|------------------	|--------------------------------------------------------------------------	|------------------------------------	|---	|---	|
| Login            	| https://demoqa.com/login<br>UserName:test123 <br>Password:Automation@123 	| A logout button appeared           	|   	|   	|
| Go To Book Store 	|                                                                          	| 8 books are returned in the table  	|   	|   	|
| Book details     	| Click on ‘Git Pocket Guide’                                              	| Details page opened (Assert title) 	|   	|   	|
| Add to your collection     	| Click on ‘Add to your collection’                                               	| ‘Book already present in the your collection!’ text appeared 	|   	|   	|
| Back To Book Store     	|                                                	| 8 books are returned in the table 	|   	|   	|
| Log out     	|                                                	| ‘Welcome,<br>Login in Book Store’ text  <br>appeared 	|   	|   	|