#Web Automation Example

- Navigate to Home Page

        home.NavigateHomePage();
- Click on the take a tour and skip it 

        home.TakeAndSkipTour();
- Select the currency and go to register page  
              
        home.SelectCurrrency("US Dollars");
        home.ProceedToSignUp();
 
- Create the new user on the register page

        register.SignUp(email, username, phoneNumber, password);
        
- Then we validate the user created        

        home.ConfirmRegist(username);
        
        
        