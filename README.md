| Step             	| Test Data                                                                	| Expected Result                    	|   	|   	|
|------------------	|--------------------------------------------------------------------------	|------------------------------------	|---	|---	|
| Create without data            	|  	|  returns 400           	|   	|   	|
| Create existing user     	| username: testuser <br> password: StrongPassword#1                                              	|  returns 406 	|   	|   	|
| Create new  user     	| username: random username <br> password: StrongPassword#1                                               	| returns 201 	|   	|   	|
