#Web Automation Example

- Navigate to Home Page

        home.NavigateHomePage();
- Click on the take a tour and skip it 

        home.TakeAndSkipTour();
- Select the currency and go to register page  
              
        home.SelectCurrency("US Dollars");
        home.GoToRegister();
 
- Create the new user on the register page

        register.SignUpAndRegister(email, username, "+351912345678", password);
        
- Then we validate the user created        

        home.ValidateRegister(username);
        
        
        