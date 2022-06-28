package SuperMarket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button login;
    
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    @FXML
    private Label msgLabel;
    
    @FXML
    private Hyperlink resetPass;

    @FXML
    private Button signUp;
    
    
    
    
    public void keyReleased(){
        String un = username.getText().trim();
        String pw = password.getText().trim();
        
        boolean isDisabled = ((un.isEmpty() && pw.isEmpty()) || un.isEmpty() || pw.isEmpty());
        
        login.setDisable(isDisabled);
        
        
        //System.out.println(isDisabled);
        //System.out.println(un);
        //System.out.println(pw);
        
    }
    
    
    @FXML
    public void btnlogin(ActionEvent event) throws IOException{
        
        //check username and password with database     //msgLabel
        //and set the text of message field to appropciate msg if invalid user or password
        
        String un = username.getText().trim();
        String pw = password.getText().trim();
        
        DBUtils.login(event, un, pw);
        
    }
    
    @FXML
    public void btnForgetPass(ActionEvent event){
        
        // to reset password
        
    }
    
    @FXML
    public void btnSignUp(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        keyReleased();
        
    }    
    
}
