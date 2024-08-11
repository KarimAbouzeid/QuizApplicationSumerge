import java.util.HashMap;

public class Users {


    private HashMap<String, String> usersList;

    public Users(){
        usersList = new HashMap<>();
    }

    public HashMap<String, String> getUsersList() {
        return usersList;
    }

    public void setUsersList(HashMap<String, String> usersList) {
        this.usersList = usersList;
    }

    public boolean isRegistered(String s){
        return usersList.containsKey(s);
    }


    public boolean isAuth(String s, String p){
        return usersList.get(s).equals(p);
    }

    public void createUser(String s, String p){
        usersList.put(s, p);
    }


}
