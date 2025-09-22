public class UserInfo{
    private String userId;
    private String userName;
    private String mob_no;
    private String password;
    private String email;

    public void UserInfo(String userId, String userName, String mob_no, String password, String email){
        this.userId=userId;
        this.userName=userName;
        this.mob_no=mob_no;
        this.password=password;
        this.email=email;
    }

    public String getUserId(){
        return userId;
    }

    public String getUserName(){
        return userName;

    }

    public String getMob_No(){
        return mob_no;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }

    
}