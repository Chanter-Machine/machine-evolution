package reflection.spring;

public class UserController {
    private UserSerivce userSerivce;

    public void setUserSerivce(UserSerivce userSerivce){
        this.userSerivce = userSerivce;
    }

    public UserSerivce getUserSerivice(){
        return this.userSerivce;
    }
}
