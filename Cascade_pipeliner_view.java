package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Cascade_pipeliner_view {
	Graph graph = new Graph();
	
	@FXML
    private Button ml_model_1;
	
	@FXML
    void info_tip_ml_model_1(MouseEvent event) {
		/* mouse-hang was detected, give user info about ml model 1*/
        System.out.println("ML Model 1 is ...");
    }
	
    @FXML
    void onMouseDraggedEventHandler(MouseEvent event) {
    		
    }

    @FXML
    void onMousePressedEventHandler(MouseEvent event) {

    }

    @FXML
    void onMouseReleasedEventHandler(MouseEvent event) {

    }
}
