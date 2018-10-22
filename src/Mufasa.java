import java.text.ParseException;
import java.text.SimpleDateFormat;




public class Mufasa {
	public class UserException extends Exception {
	    public UserException(String message) {
	        super(message);
	    }
	}
   


	public class User {
		private String FirstName; 
		private String LastName;
		private String Username;
		private String Password;  //check confirm password
		private String Country;
		private String birthdate;  //dd/mm/yyyy // at least 18 years old
		private String PhoneNumber;
		private String Email;  //check confirm email
		
		
		public User() {
			// TODO Auto-generated constructor stub
		}


		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return FirstName;
		}


		/**
		 * @param firstName the firstName to set
		 * @throws UserException 
		 */
		public void setFirstName(String firstName) throws UserException {
			String pattern = "^[A-z]+$";
			boolean check = firstName.matches(pattern);
			if(check == true){
				FirstName = firstName;
			}else{
				throw new UserException("First Name is invalid");
			}
		}


		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return LastName;
		}


		/**
		 * @param lastName the lastName to set
		 * @throws UserException 
		 */
		public void setLastName(String lastName) throws UserException {
			String pattern = "^[A-z]+$";
			boolean check = lastName.matches(pattern);
			if(check == true){
				LastName = lastName;
			}else{
				throw new UserException("Last Name is invalid");
			}
		}


		/**
		 * @return the username
		 */
		public String getUsername() {
			return Username;
		}


		/**
		 * @param username the username to set
		 * @throws UserException 
		 */
		public void setUsername(String username) throws UserException {
			String pattern = "^[a-zA-Z+][[A-Za-z\\d_+]{4,15}$";
			boolean check = username.matches(pattern);
			if(check == true){
				Username = username;
			}else{
				throw new UserException("Username is invalid");
			}
		}


		/**
		 * @return the password
		 */
		public String getPassword() {
			return Password;
		}


		/**
		 * @param password the password to set
		 * @throws UserException 
		 */
		public void setPassword(String password, String confirmPassword) throws UserException {
			String pattern = "^(?=.*[a-zA-Z!@#$%^&*()_+])[[A-Za-z\\d!@#$%^&*()_+]{8,19}$";
			boolean check = password.matches(pattern);
			if(check == true && password == confirmPassword){
				Password = password;
			}else{
				throw new UserException("Password is invalid");
			}
		}


		/**
		 * @return the country
		 */
		public String getCountry() {
			return Country;
		}


		/**
		 * @param country the country to set
		 * @throws UserException 
		 */
		public void setCountry(String country) throws UserException {
			String pattern = "^[A-z]+$";
			boolean check = country.matches(pattern);
			if(check == true){
				Country = country;
			}else{
				throw new UserException("Country is invalid");
			}
		}
		/**
		 * @return the birthdate
		 */
		public String getBirthdate() {
			return birthdate;
		}
		
		/**
		 * @param birthdate the birthdate to set
		 */
		
		public boolean isValidBirthDate(String input) throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		     try {
		          format.parse(input);
		          return true;
		     }
		     catch(ParseException e){
		          return false;
		     }
		}
		
		
		public void setBirthdate(String birthdate) throws UserException, ParseException {
			boolean check = isValidBirthDate(birthdate);
			if(check == true){
				this.birthdate = birthdate;
			}else{
				throw new UserException("birthdate is invalid");
			}
		}


		/**
		 * @return the phoneNumber
		 */
		public String getPhoneNumber() {
			return PhoneNumber;
		}


		/**
		 * @param phoneNumber the phoneNumber to set
		 * @throws UserException 
		 */
		public void setPhoneNumber(String phoneNumber) throws UserException {
			String pattern = "^[0-9]+$";
			boolean check = phoneNumber.matches(pattern);
			if(check == true){
				PhoneNumber = phoneNumber;
			}else{
				throw new UserException("Phone Number is invalid");
			}
		}


		/**
		 * @return the email
		 */
		public String getEmail() {
			return Email;
		}


		/**
		 * @param email the email to set
		 * @throws UserException 
		 */
		public void setEmail(String email, String confirmEmail) throws UserException {
			String pattern = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}";
			boolean check = email.matches(pattern);
			if(check == true && email == confirmEmail){
				Email = email;
			}else{
				throw new UserException("Email is invalid");
			}
		}

	}
	


}
