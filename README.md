# api-alvaro-afteroffice-katalon
This repository was created to complete the final project for the Afteroffice Bootcamp. This project will do some basic UI automation testing on the mock web, demoqa.com.

### Preparation
This project was developed using __Katalon Studio Enterprise Version - 10.2.1__ and several function not available in free version. so please use __Katalon Studio Enterprise Version__ to run this project

### How to Use
Assume we're going to execute `Testing Main Function (Inquiry, Register, Delete Data)`. By default, user can execute without any prior preparation. All needed data already saved in `Test Data` folder. Please check the documentation if need some adjusment.

### Result Report Example
Please check the result report example. [Result Report Example](https://htmlpreview.github.io/?https://github.com/alvarobasilys/web-alvaro-afteroffice-katalon/blob/main/Example%20Report%20Result/20250617_030853.html)

Some test cases mark as failure due some api can be sent without input api key

### About Response Validation
All response validation, including the structure of the response and the data type, will be validate by using Json Scheme in Object Reference level. Please check `Data Files\jsonScheme' to check the detail of the validation

### Documentation 

### Profile
<details>
<summary> Default.glbl </summary>

| Name                  | Value Type | Description                                                                                             |
|-----------------------|------------|---------------------------------------------------------------------------------------------------------|
| baseUrl               | String     | Base Url for access the API                                                                             |
| apiKey                | String     | Api Key                                                                                                 |

</details>

### Test Case

<details>
<summary> Verify Get Users.tc </summary>

This test case will verify Get Users response based on inputed data. This test case need data input, so this test case using Data Binding `Data Files\Verify Get Users Data.dat` in test case level.
To Add, Edit, or Remove the input value please check and edit `Data Files\Excel File\Verify Get Users.xlsx`.

There're two condition based on response error code:
- error `401`: Test case will verify between the actual error message from the response and expected error message
- error `200`: When request is success, test case will verify between inputted `page` value and the `page` value from the response

By Default, user can use this test case directly without any prior preparation is required

</details>


<details>
<summary> Verify Get Single User.tc </summary>

This test case will verify Get Single User response based on inputed data. This test case need data input, so this test case using Data Binding `Data Files\Verify Get Single User Data.dat` in test case level.
To Add, Edit, or Remove the input value please check and edit `Data Files\Excel File\Verify Get Single User.xlsx`.

There're three condition based on response error code:
- error `401`: Test case will verify between the actual error message from the response and expected error message
- error `404`: Mean no user found based on inputted id, so the test case will verify the response structure 
- error `200`: There're two possibilities:
  - Test case will verify between inputted page value and the page value from the response __if the request doesn't have `userId`__.
  - If `userId` inputted in the request, then the test case will verify betweeh inputted `userId` and `userId` from the response 

By Default, user can use this test case directly without any prior preparation is required

</details>

<details>
<summary> Verify Get Single User.tc </summary>

This test case will verify Get Single User response based on inputed data. This test case need data input, so this test case using Data Binding `Data Files\Verify Get Single User Data.dat` in test case level.
To Add, Edit, or Remove the input value please check and edit `Data Files\Excel File\Verify Get Single User.xlsx`.

There're three condition based on response error code:
- error `401`: Test case will verify between the actual error message from the response and expected error message
- error `404`: Mean no user found based on inputted id, so the test case will verify the response structure 
- error `200`: There're two possibilities:
  - Test case will verify between inputted page value and the page value from the response __if the request doesn't have `userId`__.
  - If `userId` inputted in the request, then the test case will verify betweeh inputted `userId` and `userId` from the response 

By Default, user can use this test case directly without any prior preparation is required

</details>

</details>

<details>
<summary> Verify Post Register.tc </summary>

This test case will verify Post Register response based on inputed data. This test case need data input, so this test case using Data Binding `Data Files\Verify Post Register Data.dat` in test case level.
To Add, Edit, or Remove the input value please check and edit `Data Files\Excel File\Verify Post Register Data.xlsx`. 

There're two condition based on response error code:
- error `401` or `400` : Test case will verify between the actual error message from the response and expected error message
- error `200`: When request is success, test case will verify between inputted `id` and the `id` from the response

By Default, user can use this test case directly without any prior preparation is required

</details>

<details>
<summary> Verify Delete User.tc </summary>

This test case will verify Post Register response based on inputed data. This test case need data input, so this test case using Data Binding `Data Files\Verify Delete User Data.dat` in test case level.
To Add, Edit, or Remove the input value please check and edit `Data Files\Excel File\Verify Delete User.xlsx`. 

To verify delete request success, the test case will verify the response status code is `204`.

If response status code not `204`, the test case will verify the error message from the respond

By Default, user can use this test case directly without any prior preparation is required

</details>
